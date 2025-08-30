package com.tonolandia.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PeliculaRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    @Min(value = 1, message = "La duración debe ser >= 1 minuto")
    private int duracionMin;
}
