package com.app.model.create;

import com.app.model.enums.TypeInternet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePackInternetDto {

    private String name;
    private String description;
    private Integer speedDownload; //in Mb/s
    private Integer speedUpload; //in Mb/s
    private TypeInternet typeInternet;
    private BigDecimal price;
}
