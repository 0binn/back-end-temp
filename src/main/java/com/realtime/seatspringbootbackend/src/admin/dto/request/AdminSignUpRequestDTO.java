package com.realtime.seatspringbootbackend.src.admin.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Email;
import com.realtime.seatspringbootbackend.common.annotation.EmployerIdNumber;
import com.realtime.seatspringbootbackend.common.annotation.Nickname;
import com.realtime.seatspringbootbackend.common.annotation.Password;
import com.realtime.seatspringbootbackend.src.user.domain.UserRole;
import com.realtime.seatspringbootbackend.src.user.domain.UserSex;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Data
public class AdminSignUpRequestDTO {
    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String email;

    @Password(message = "비밀번호는 8자 이상의 영문 + 숫자 + 특수기호 조합만 허용합니다.")
    private String password;

    private String passwordChecked;

    @Nickname(message = "닉네임 형식이 맞지 않습니다.")
    private String nickname;

    private int age;
    private UserSex sex;
    private UserRole role;
    private Boolean consentToMarketing;
    private Boolean consentToTermsOfUser;

    @EmployerIdNumber(message="사업자등록번호는 10자리의 숫자입니다.")
    @NotBlank(message = "사업자등록번호가 입력되지 않았습니다.")
    private String employerIdNumber;

    @NotBlank(message = "오픈일자가 입력되지 않았습니다.")
    private String openDate;

    @NotBlank(message = "대표자 이름이 입력되지 않았습니다.")
    private String adminName;
}
