package com.tonolandia.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pelicula {

    private Long id;
    private String titulo;
    private int duracionMin;
}
