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
public @interface YearMonth {

    String message() default "year month 양식에 맞지 않습니다 ex)20230101";

    String pattern() default "yyyymmdd";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
