package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidateEmailReq {
    @Email(message = "이메일은 @까지 포함해 올바른 형식을 입력해주세요.")
    private String email;
}
