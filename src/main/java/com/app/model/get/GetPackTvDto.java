package com.app.model.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPackTvDto {

    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
}
