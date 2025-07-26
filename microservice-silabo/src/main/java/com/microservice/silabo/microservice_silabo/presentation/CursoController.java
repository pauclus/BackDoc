package com.microservice.silabo.microservice_silabo.presentation;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.silabo.microservice_silabo.domain.Curso;
import com.microservice.silabo.microservice_silabo.application.CursoService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/por-nombre")
    public Flux<Curso> getAllCursos(@RequestParam String parteNombre) {
        return cursoService.obtenerPorNombre(parteNombre);
    }
}
