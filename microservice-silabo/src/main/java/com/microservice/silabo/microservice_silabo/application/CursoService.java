package com.microservice.silabo.microservice_silabo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

import com.microservice.silabo.microservice_silabo.domain.Curso;
import com.microservice.silabo.microservice_silabo.infrastructure.CursoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Flux<Curso> obtenerPorNombre(String nombre) {
        return cursoRepository.findByParteNombre(nombre);
    }

    public Mono<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public Mono<Curso> obtenerPorCodigo(String codigo) {
        return cursoRepository.findByCodigo(codigo);
    }

}
