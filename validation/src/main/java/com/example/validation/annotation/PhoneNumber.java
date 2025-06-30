package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// annotation으로 valid 검증 하는 법, 예외처리
@Target({ElementType.FIELD}) // 사용 대상 : 변수에만 붙임
@Retention(RetentionPolicy.RUNTIME) // 실행 시점 = 실행 중에만
@Constraint(validatedBy = PhoneNumberValidator.class) // 검증을 어떤 class로 할건지
public @interface PhoneNumber {

    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex) 000-0000-0000";

    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
