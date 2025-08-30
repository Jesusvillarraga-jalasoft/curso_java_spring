package com.tonolandia.demo.api;

import com.tonolandia.demo.dto.PeliculaRequest;
import com.tonolandia.demo.dto.PeliculaResponse;
import com.tonolandia.demo.service.PeliculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final PeliculaService service;

    @GetMapping
    public List<PeliculaResponse> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeliculaResponse crear(@Valid @RequestBody PeliculaRequest req) {
        return service.crear(req);
    }
}
