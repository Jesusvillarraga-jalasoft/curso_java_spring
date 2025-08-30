package com.tonolandia.demo.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PeliculaResponse {

    Long id;
    String titulo;
    int duracionMin;
}
