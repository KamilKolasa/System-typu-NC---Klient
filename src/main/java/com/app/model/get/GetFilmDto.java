package com.app.model.get;

import com.app.model.CategoryDto;
import com.app.model.enums.Quality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetFilmDto {

    private Long id;

    private String title;
    private Integer yearProduction;
    private String description;
    private BigDecimal price;
    private Quality quality;

    private CategoryDto category;
}
