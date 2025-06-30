package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 응답 값이 JSON으로 하겠다.
// @Controller <- 응답값 JSON 말고도 가능
// Controller 선언 시 @ResponseBody 따로 붙여주지 않으면 에러
@RequestMapping("/api/v1")
public class ResponseApiController {

    @GetMapping("")
    // 상황에 따라 원하는 response custom 하는 방법
    public ResponseEntity<UserRequest> user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setPhoneNumber("123456789");
        user.setEmail("Hong@gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED) // 201 코드 반환
                .header("x-custom", "hi")
                .body(user); // body에 user객체 담아 반환

        return response;
    }
}
