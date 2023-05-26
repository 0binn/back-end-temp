package com.realtime.seatspringbootbackend.src.user.api;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import com.realtime.seatspringbootbackend.common.exceptions.BaseException;
import com.realtime.seatspringbootbackend.src.user.dto.request.UserSignInReq;
import com.realtime.seatspringbootbackend.src.user.dto.request.UserSignUpReq;
import com.realtime.seatspringbootbackend.src.user.dto.request.ValidateEmailReq;
import com.realtime.seatspringbootbackend.src.user.dto.request.ValidateNicknameReq;
import com.realtime.seatspringbootbackend.src.user.dto.response.ValidateUserInformationRes;
import com.realtime.seatspringbootbackend.src.user.service.UserSignInService;
import com.realtime.seatspringbootbackend.src.user.service.UserSignUpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Tag(name = "01. [User]")
@RequestMapping("/v1/users")
@Validated
@RequiredArgsConstructor
public class UserApi {
    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;

    @Operation(summary = "이메일 검증 및 중복 확인")
    @PostMapping("/validate/email")
    public ValidateUserInformationRes validateEmail(
            @Valid @RequestBody ValidateEmailReq validateEmailReq) {
        return userSignUpService.isEmailDuplicated(validateEmailReq.getEmail());
    }

    @Operation(summary = "닉네임 검증 및 중복 확인")
    @PostMapping("/validate/nickname")
    public ValidateUserInformationRes validateNickname(
            @Valid @RequestBody ValidateNicknameReq validateNicknameReq) {
        return userSignUpService.isNicknameDuplicated(validateNicknameReq.getNickname());
    }

    @Operation(summary = "유저 회원가입")
    @PostMapping("/sign-up")
    public void userSignUp(@Valid @RequestBody UserSignUpReq userSignUpReq) {
        userSignUpService.userSignUp(userSignUpReq);
    }

    @Operation(summary = "유저 로그인")
    @PostMapping("/sign-in")
    public void userSignIn(@Valid @RequestBody UserSignInReq userSignInReq) {
        if(!userSignInService.isExistEmail(userSignInReq.getEmail())) {
            throw new BaseException(ResponseCode.SIGN_IN_FAIL);
        }

        userSignInService.userSignIn(userSignInReq);
    }
}
