package com.tonolandia.demo.service;

import com.tonolandia.demo.domain.Pelicula;
import com.tonolandia.demo.dto.PeliculaRequest;
import com.tonolandia.demo.dto.PeliculaResponse;
import com.tonolandia.demo.mapper.PeliculaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PeliculaService {

    private final PeliculaMapper mapper;

    private final List<Pelicula> data = new ArrayList<>();
    private final AtomicLong seq = new AtomicLong(1);

    // seed
    {
        data.add(Pelicula.builder().id(seq.getAndIncrement()).titulo("El Viaje del Código").duracionMin(120).build());
        data.add(Pelicula.builder().id(seq.getAndIncrement()).titulo("Refactor Wars").duracionMin(105).build());
    }

    public List<PeliculaResponse> listar() {
        return data.stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public PeliculaResponse crear(PeliculaRequest req) {
        Pelicula entity = mapper.toEntity(req);
        entity.setId(seq.getAndIncrement());
        data.add(entity);
        log.info("Nueva película: {}", entity);
        return mapper.toResponse(entity);
    }
}
