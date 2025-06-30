package com.example.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Api<T> { // 해당 형식을 이용해 에러가 나도 동일한 형식을 return 해줄 수 있도록

    private String resultCode;

    private String resultMessage;

    private T data; // generic으로 data type 다양하게
}
