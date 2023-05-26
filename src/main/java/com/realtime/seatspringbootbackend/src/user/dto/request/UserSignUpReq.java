package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Password;
import com.realtime.seatspringbootbackend.src.user.domain.UserSex;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserSignUpReq {
    private String email;
    @Password(message = "비밀번호는 8자 이상의 영문 + 숫자 + 특수기호 조합만 허용합니다.")
    private String password;
    private String nickname;
    private int age;
    private UserSex sex;
    private Boolean consentToMarketing;
    private Boolean consentToTermsOfUser;
}
