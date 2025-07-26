package com.microservice.silabo.microservice_silabo.infrastructure;

import org.springframework.stereotype.Repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.Query;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import com.microservice.silabo.microservice_silabo.domain.Curso;

@Repository
public interface CursoRepository extends R2dbcRepository<Curso, Long> {

    @Query("SELECT * FROM curso WHERE id = :id")
    Mono<Curso> findById(Long id);

    @Query("SELECT * FROM curso WHERE codigo = :codigo")
    Mono<Curso> findByCodigo(String codigo);

    @Query("SELECT * FROM curso WHERE LOWER(nombre) LIKE LOWER(CONCAT(:nombre, '%'))")
    Flux<Curso> findByParteNombre(String nombre);



}
