package com.example.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoQueryParam {
    private int num1;
    private int num2;
    private String name;
    private boolean isMan;

    public int sum(){
        return num1 + num2;
    }

    public int multiply(){
        return num1 * num2;
    }
}
