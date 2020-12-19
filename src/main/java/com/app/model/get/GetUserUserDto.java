package com.app.model.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserUserDto {

    private Long id;

    private String username;
    private String email;
    private String enabled;
}
