package com.example.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok을 이용하여 메소드 자동 생성
@Data // getter, setter 등 생성
@NoArgsConstructor // args없는 기본 생성자 자동 생성
@AllArgsConstructor // 아래 4개의 값을 인자로 받는 생성자 자동 생성
public class BookQueryParam {

    private String category;

    private String issuedYear;

    private String issuedMonth;

    private String issuedDay;

}
