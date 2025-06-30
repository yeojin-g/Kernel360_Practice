package com.example.memorydb.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service // 같은 패키지 내의 Bean
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {


    public List<UserEntity> findAllScoreGreaterThen(int score){

        return this.findAll().stream()
                .filter(
                        it -> {return it.getScore() >= score;}
                ).collect(Collectors.toList());


    }


}
