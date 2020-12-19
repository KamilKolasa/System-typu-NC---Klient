package com.app.model.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBuyFilmDto {

    private LocalDate dateStart;
    private LocalDate dateEnd;

    private Long filmId;
    private Long userId;
}
