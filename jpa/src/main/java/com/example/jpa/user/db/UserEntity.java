package com.example.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="user") // mapping할 table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql에 의해 자동 생성
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
