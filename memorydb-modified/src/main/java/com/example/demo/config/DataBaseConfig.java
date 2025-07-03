package com.example.demo.config;

import com.example.demo.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// spring app 실행 시 configuration을 찾아서 특정 내용들을 spring context라는 곳에 객체로 만들어 둠
// 이후에 service, controller등에서 해당 내용 필요 시 spring이 알아서 주입해줌
/*
현재는 패키지 내부에 함께 있어서 직접 생성해줄 필요 없음 (UserRepository)
만약 외부에 있는 걸 사용하고 싶으면 해당 방식 이용할 것
지금은 @Service annotation 붙여주면 됨 - UserRepo~에다가

@Configuration
public class DataBaseConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }
}
 */
