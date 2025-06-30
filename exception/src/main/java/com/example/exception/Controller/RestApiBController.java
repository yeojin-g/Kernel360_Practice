package com.example.exception.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("Number Format Exception");
    }

    /*
    특정 Exception에 대해 같은 controller level 내에서 잡을 수 있음
    만약 해당 Exception Handler가 없을 경우, global handler가 처리
    - controller code 길이가 길 경우 비추천, 해당 경우에는 exception에서 처리 가능
     */

    /*@ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity numberFormatException(
            NumberFormatException e
    ){
        log.error("RestApiBController", e);

        return ResponseEntity.ok().build();
    }
     */
}
