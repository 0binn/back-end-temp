package com.realtime.seatspringbootbackend.src.store.exception;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import lombok.Getter;

@Getter
public class StoreInactiveException extends Exception {
    private final ResponseCode responseCode;

    public StoreInactiveException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
