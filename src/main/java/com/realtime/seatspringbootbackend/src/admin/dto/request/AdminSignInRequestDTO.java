package com.realtime.seatspringbootbackend.src.admin.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Email;
import com.realtime.seatspringbootbackend.common.annotation.Password;

public class AdminSignInRequestDTO {
    @Email(message = "이메일 형식이 맞지 않습니다.")
    private String email;

    @Password(message = "비밀번호는 8자 이상의 영문 + 숫자 + 특수기호 조합의 형식입니다.")
    private String password;
}
