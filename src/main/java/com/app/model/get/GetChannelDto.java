package com.app.model.get;

import com.app.model.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetChannelDto {

    private Long id;

    private String name;
    private String description;

    private CategoryDto category;
}
