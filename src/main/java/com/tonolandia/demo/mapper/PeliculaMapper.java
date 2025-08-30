package com.tonolandia.demo.mapper;

import com.tonolandia.demo.domain.Pelicula;
import com.tonolandia.demo.dto.PeliculaRequest;
import com.tonolandia.demo.dto.PeliculaResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PeliculaMapper {

    Pelicula toEntity(PeliculaRequest req);

    PeliculaResponse toResponse(Pelicula entity);

    @AfterMapping
    default void normalize(@MappingTarget Pelicula target, PeliculaRequest source) {
        if (source.getTitulo() != null) {
            target.setTitulo(source.getTitulo().trim());
        }
    }
}
