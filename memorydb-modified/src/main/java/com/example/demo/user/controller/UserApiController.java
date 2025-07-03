package com.example.demo.user.controller;

import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor // 생성자 처리 자동으로
public class UserApiController {
    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity); // 구현체는 simpleRepo에
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam Integer score
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> filterScore(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.filterScore(min, max);
    }
}
