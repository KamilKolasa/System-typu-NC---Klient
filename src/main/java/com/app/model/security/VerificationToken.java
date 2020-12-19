package com.app.model.security;

import com.app.model.create.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerificationToken {
    private Long id;

    private String token;
    private LocalDateTime expirationDateTime;
    private CreateUserDto createUserDto;
}
