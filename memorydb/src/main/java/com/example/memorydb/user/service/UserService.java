package com.example.memorydb.user.service;

import com.example.memorydb.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){

        return  userRepository.save(user);

    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> filterScore(int score){
        return userRepository.findAllScoreGreaterThen(score);
    }

}
