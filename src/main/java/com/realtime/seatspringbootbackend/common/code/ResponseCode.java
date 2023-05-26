package com.realtime.seatspringbootbackend.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

/** 에러 및 성공 코드 관리 */
@Getter
@AllArgsConstructor
public enum ResponseCode {
    /** 200 : 요청 성공 */
    SUCCESS(OK, "OK", "요청에 성공하였습니다."),

    /**
     * User
     */
    SIGN_IN_FAIL(BAD_REQUEST, "USER_400_001", "로그인에 실패했습니다."),

    /** 400 : Request, Response 오류 */
    INVALID_FIELD_VALUE(BAD_REQUEST, "BAD_REQUEST", "필드 값이 올바르지 않습니다."),

    /** 500 : Database, Server 오류 */
    INTERNAL_ERROR(INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", "서버와의 연결에 실패하였습니다.");



    private final HttpStatus status;
    private final String code;
    private final String message;
}
