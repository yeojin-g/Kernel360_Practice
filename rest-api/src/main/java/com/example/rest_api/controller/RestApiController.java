package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import com.example.rest_api.model.TodoQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // RestApi처리 controller임을 명시
@RequestMapping("/api") // /api 로 시작되는 주소는 해당 컨트롤러로 요청을 받겠다, 진입점 지정
public class RestApiController {

    // annotation을 통해 쉽게 역할 부여
    // get메소드 annotation
    @GetMapping(path = "/hello") // 해당 메소드를 수행할 path 설정 - /api/hello
    public String hello(){
        return "Hello Spring Boot!";
    }

    @GetMapping(path = "/hello2")
    public String hello2(){ // html return ver.
        var html = "<html><body><h1>Hello Spring Boot!</h1></body></html>";
        return html;
    }

    /*
    주고받는 것은 문자열, 이를 해석하기 나름
    이미지와 같은 다른 data들도 결국 문자열로 주고받고 이를 인코딩하여 보여주는 것
    */

    // Path Variable
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
           // @PathVariable String message // path variable - annotation 사용
           @PathVariable(name = "message") String msg,
           @PathVariable int age,
           @PathVariable boolean isMan// path variable과 변수명이 달라도 어떤 path variable과 mapping 시킬지 명시 가능
    ){
        System.out.println("echo message: " + msg);
        System.out.println("echo age: " + age);
        System.out.println("echo is-man: " + isMan);

        //TODO 대문자로 변환해서 return
        //TODO 다양한 type의 변수 받아보기 - boolean, integer..


        return msg.toUpperCase() + age + isMan;
    }

    // Query Parameter
    // http://localhost:8080/api/book?category=IT&issuedYear=2025&issued-month=01&issued_day=31

    @GetMapping(path = "/book")
    public void qeuryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam String issued_day
    ) {
        System.out.println("Category: " + category);
        System.out.println("Issued Year: " + issuedYear);
        System.out.println("Issued Month: " + issuedMonth);
        System.out.println("Issued Day: " + issued_day);
    }

    // Query Param - 객체를 통한 parsing
    @GetMapping(path = "/book2")
    public void qeuryParamDto(
            BookQueryParam bookQueryParam // 객체로 받기
    ) {
        System.out.println(bookQueryParam);
    }

    // TODO Parameter 2가지 받기 - int 형태로 받아서 덧셈, 곱셈 수행 메소드 만들기
    // TODO String, Boolean 타입도 받아보기
    // http://localhost:8080/api/todo?num1=3&num2=7&name=Steve&isMan=true
    @GetMapping(path = "/todo")
    public void qeuryParamTodo(
        TodoQueryParam todoQueryParam
    ){
        System.out.println(todoQueryParam);
        System.out.println("sum: " + todoQueryParam.sum());
        System.out.println("multiply: " + todoQueryParam.multiply());
    }

    // Delete API
    @DeleteMapping(path = { // 여러 루트 지정 가능, path = <- 생략 가능
            "user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
