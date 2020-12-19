package com.app.model.create;

import com.app.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {

    private String username;
    private String password;
    private String passwordConfirmation;
    private String email;
    private Boolean enabled;
    private Role role;
}
