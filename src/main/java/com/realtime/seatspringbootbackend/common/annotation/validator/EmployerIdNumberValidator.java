package com.realtime.seatspringbootbackend.common.annotation.validator;

import com.realtime.seatspringbootbackend.common.annotation.EmployerIdNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployerIdNumberValidator implements ConstraintValidator<EmployerIdNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches("^[0-9]{10}$"); //XXX-XXXX-XXXX-XX
    }
}
