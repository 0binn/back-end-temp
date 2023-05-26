package com.realtime.seatspringbootbackend.src.user.dto.request;

import com.realtime.seatspringbootbackend.common.annotation.Nickname;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ValidateNicknameReq {
    @Nickname(message = "닉네임은 4~12자의 영문(대,소문자 구분)과 숫자만 허용합니다")
    private String nickname;
}
