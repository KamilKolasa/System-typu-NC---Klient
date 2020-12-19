package com.app.model.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePackDto {

    private String name;
    private String description;
    private Integer discount;

    private Long packPhoneId;
    private Long packInternetId;
    private Long packTvId;
}
