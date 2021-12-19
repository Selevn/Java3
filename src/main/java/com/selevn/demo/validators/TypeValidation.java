package com.selevn.demo.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TypeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeValidation {
    String message() default "Invalid type provided";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}