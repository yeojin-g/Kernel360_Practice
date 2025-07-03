package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    // 해당 annotation없이 final로 생성해도 됨
    private UserRepository userRepository;

    public UserEntity save(UserEntity user){
        // save
        return userRepository.save(user);
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
        return userRepository.findAllByScoreGreaterThan(score);
    }

    public List<UserEntity> filterScore(int min, int max){
//        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
        return userRepository.score(min, max);

    }

}
