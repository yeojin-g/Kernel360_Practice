package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<UserRegisterRequest> register( // 정상적인 로직만 남겨두고 예외처리는 Exception에서

        @Valid // 요청이 들어올 때, annotation을 기반으로 검증 시행
        @RequestBody
        Api<UserRegisterRequest> userRegisterRequest
    ){
        log.info("init: {}", userRegisterRequest);

        var body = userRegisterRequest.getData();

        var response = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}

