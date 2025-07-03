package com.example.simple_board.post.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostViewRequest {
    @NotNull
    private Long postId;

    @NotBlank
    private String password;
}
