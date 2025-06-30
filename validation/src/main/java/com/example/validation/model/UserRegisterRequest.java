package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//    @NotNull // != null
//    @NotEmpty // != null && != ""
//    @NotBlank // != null && != "" && != "  "
    private String name;

    private String nickname;

    @Size(min = 1, max = 12) // 1 ~ 12
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private String age;

    @Email
    private String email;

//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") // 정규표현식
    @PhoneNumber // custom annotation 사용
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name or nickname은 반드시 1개가 존재 해야 합니다.") // 둘 중 하나라도 존재 시 pass, is로 시작하는 메소드에 무조건 붙여줘야함
    // @AssertFalse false Return시
    public boolean isNameCheck(){
        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }

        if(Objects.nonNull(nickname) && !nickname.isBlank()){
            return true;
        }

        return false;
    }
}
