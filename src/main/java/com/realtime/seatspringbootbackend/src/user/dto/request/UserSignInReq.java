package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Email;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserSignInReq {
    @Email(message = "이메일은 @까지 포함해 올바른 형식을 입력해주세요.")
    private String email;

    private String password;
}
