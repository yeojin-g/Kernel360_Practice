package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class  RestApiApplicationTests {

	// 직렬화(OBJECT -> JSON), 역직렬화(JSON -> OBJECT) 수행
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		var user = new UserRequest();
		user.setUserName("홍길동");
		user.setPhoneNumber("123456789");
		user.setEmail("hong@gmail.com");
		user.setIsKorean(true);

		/*
		ObjectMapper의 작동 원리
		1. 직렬화
		- 직렬화 시 변수를 기준으로 하는 것이 아닌 getter 메소드 기준으로 동작
			- 변수명 name, getter메소드 명 getHumanName
			-> 직렬화 결과 : "human_name" : "홍길동"

		2. 역직렬화
		- setter 메소드 기준으로 동작하지만 getter만 있어도 동작
			- JSON의 key와 matching되는 value를 받아와 JSON의 key값과 연결하여 생성
			- 만약 JSON파일에 key값은 "user_names"이고 setter가 setUserName이라면 결과 "userName" : null
				- 이런 경우엔 userName변수 위에 @JsonProperty("user_names") annotation 이용 가능
		 */
		var json = objectMapper.writeValueAsString(user); // object -> json
		System.out.println(json);

		var dto = objectMapper.readValue(json, UserRequest.class); // json -> object
		System.out.println(dto);
	}

}
