package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoDto<T> {

    @Builder.Default
    private T data = null;

    @Builder.Default
    private String error = null;
}
