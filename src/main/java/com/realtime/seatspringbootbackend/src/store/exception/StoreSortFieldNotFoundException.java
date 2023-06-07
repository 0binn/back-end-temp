package com.realtime.seatspringbootbackend.src.store.exception;

import com.realtime.seatspringbootbackend.common.code.ResponseCode;
import lombok.Getter;

@Getter
public class StoreSortFieldNotFoundException extends Exception {
    private final ResponseCode responseCode;

    public StoreSortFieldNotFoundException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
