package com.realtime.seatspringbootbackend.common.annotation;

import com.realtime.seatspringbootbackend.common.annotation.validator.EmployerIdNumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployerIdNumberValidator.class)
public @interface EmployerIdNumber {
    String message() default "";

    Class[] groups() default {};

    Class[] payload() default {};
}
