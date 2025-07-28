package com.microservice.silabo.microservice_silabo.infrastructure;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.microservice.silabo.microservice_silabo.domain.Silabo;

public interface SilaboRepository extends R2dbcRepository<Silabo, Long>{
    @Query("SELECT * FROM silabo WHERE curso_id = :cursoId")
    Flux<Silabo> findByCursoId(String cursoId);

    @Query("""
        INSERT INTO silabo 
        (curso_id, nombre, estrategia_didactica, bibliografia) 
        VALUES (:cursoId, :nombre, :estrategiaDidactica, :bibliografia)
        RETURNING *
    """)
    Mono<Silabo> createSilabo(Silabo silabo);

    @Modifying
    @Query("""
        UPDATE silabo 
        SET nombre = :nombre, estrategia_didactica = :estrategiaDidactica, bibliografia = :bibliografia 
        WHERE id = :id
        """)
    Mono<Void> updateSilabo(Silabo silabo);

    @Query("DELETE FROM silabo WHERE id = :id")
    Mono<Void> deleteSilabo(Long id);

}
