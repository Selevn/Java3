package com.selevn.demo.validators;

import com.selevn.demo.utils.TypeParser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeValidator implements ConstraintValidator<TypeValidation, String> {

        @Override
        public void initialize(TypeValidation contactNumber) {
        }

        @Override
        public boolean isValid(String type,
                               ConstraintValidatorContext cxt) {
            return TypeParser.parse(type) != -1;
        }

    }

