package com.realtime.seatspringbootbackend.src.admin.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.admin.domain.AdminInfoEntity;
import com.realtime.seatspringbootbackend.src.admin.dto.request.AdminSignInRequestDTO;
import com.realtime.seatspringbootbackend.src.admin.dto.request.AdminSignUpRequestDTO;
import com.realtime.seatspringbootbackend.src.admin.service.AdminSignUpService;
import com.realtime.seatspringbootbackend.src.user.domain.User;
import com.realtime.seatspringbootbackend.src.user.domain.UserRole;
import com.sun.xml.bind.v2.TODO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/v1/admins")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "03. [Admin]")
public class AdminApi {
    private final AdminSignUpService adminSignUpService;

    @Operation(summary = "어드민 회원가입")
    @PostMapping("/sign-up")
    public void adminSignUp(@Valid @RequestBody AdminSignUpRequestDTO adminSignUpRequestDTO) {

        try {
            User newAdmin = new User(adminSignUpRequestDTO.getEmail(),
                    adminSignUpRequestDTO.getPassword(),UserRole.ADMIN,adminSignUpRequestDTO.getEmployerIdNumber(),adminSignUpRequestDTO.getAge(),
                    adminSignUpRequestDTO.getNickname(),adminSignUpRequestDTO.getSex(),  adminSignUpRequestDTO.getConsentToMarketing(),adminSignUpRequestDTO.getConsentToTermsOfUser());

            LocalDate openDate = LocalDate.parse(adminSignUpRequestDTO.getOpenDate(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            AdminInfoEntity newAdminInfo = new AdminInfoEntity(newAdmin,adminSignUpRequestDTO.getEmployerIdNumber(),
                    openDate, adminSignUpRequestDTO.getAdminName());

            adminSignUpService.checkValidation(adminSignUpRequestDTO);

            adminSignUpService.save(newAdmin);
            adminSignUpService.save(newAdminInfo);
            System.out.println("newAdminInfo.getUser().getNickname() = " + newAdminInfo.getUser().getNickname());
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BaseException(ResponseCode.INTERNAL_ERROR);
        }
    }
    // TODO email validator랑 password
    // TODO admin_info 테이블에 따로 빼기

    @Operation(summary = "어드민 로그인")
    @PostMapping("/sign-in")
    public void adminSignIp(@Valid @RequestBody AdminSignInRequestDTO adminSignInpRequestDTO) {

    }
}
