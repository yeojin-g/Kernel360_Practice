package com.example.validation.validator;

import com.example.validation.annotation.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

//phoneNumber annotation 달려있는 애들을 검증해주는 class
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private String regexp;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        boolean result = Pattern.matches(value, regexp);
        return result;
    }
}
