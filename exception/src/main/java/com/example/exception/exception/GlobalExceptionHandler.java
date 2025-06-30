package com.example.exception.exception;

import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
// 예측하지 못하는 예외 처리를 위한 Global 예외 처리 핸들러
// 가장 최후에 적용 되어야 할 핸들러 = max값
//@Order(Integer.MAX_VALUE) // default값이 max이므로 굳이 지정 X
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ) {
        log.error("", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
