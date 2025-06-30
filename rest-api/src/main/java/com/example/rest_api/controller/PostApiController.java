package com.example.rest_api.controller;

import com.example.rest_api.model.BookRequest;
import com.example.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public String post(
            // JSON 형식을 객체에 mapping해줌
            /*
            JSON 형식 => key : value
            String : 문자
            Number : 숫자(float, int, double, float)
            Boolean : T/F
            {} : Object
            [] : Array

            {
                "name" : "Spring Boot",
                "number" : "100",
                "category" : "JAVA"
             }
             */

            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    // TODO RequestBody로 사용자 이름, 전화번호, 이메일을 받는 POST Method 만들기
    @PostMapping("/user")
    public void user(
            @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);
    }

}
