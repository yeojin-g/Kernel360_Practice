package com.example.exception.exception;

import com.example.exception.Controller.RestApiBController;
import com.example.exception.Controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
// Rest API 사용하는 곳의 예외 감지
// 특정 package 하위 레벨의 모든 예외 감지 - 특정 패키지의 예외 처리 지정 가능
//@RestControllerAdvice(basePackages = "com.example.exception.controller")

// 특정 클래스의 예외처리 지정 가능 - 여러 개 가능
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
@Order(1) // global handler보다 우선적으로 실행되도록
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class}) // 잡고자 하는 예외 클래스 명시 : 현재는 모든 예외 모두 감지
    public ResponseEntity exception(
        Exception e // 발생한 예외
    ){
        log.error("RestApiExceptionHandler", e); // error log
        return ResponseEntity.status(200).build(); // status를 200으로, body는 empty
    }

    @ExceptionHandler(value = { IndexOutOfBoundsException.class}) // 특정 예외만 감지
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = { NoSuchElementException.class}) // Not Found Error 처리
    public ResponseEntity noSuchElement(
            NoSuchElementException e
    ){
        log.error("NoSuchElementException", e);

        var response =  Api.builder()
                        .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                        .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                        .build();

        return ResponseEntity // 예외 처리 - 동일한 형식 보장
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
