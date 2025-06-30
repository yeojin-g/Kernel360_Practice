package com.example.rest_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// snake case 변수를 camel case 변수에 mapping
// "phone_number" : "~~" => phoneNumber에 mapping
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;

    private String phoneNumber;

    @JsonProperty("user_email") // 특정 변수의 이름을 JSON에 강제화 할 수 있는 annotation
    private String email;

    private Boolean isKorean;

    // 이 메소드로 인해 objectMapper 수행 시 원하지 않는 결과 나올 수 있음
    @JsonIgnore // Json에 사용하지 않겠다는 annotation - objectMapper 수행 시 영향 X
    public String getUser(){
        return this.userName;
    }
}
