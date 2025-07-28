package com.microservice.silabo.microservice_silabo.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.silabo.microservice_silabo.domain.Silabo;
import com.microservice.silabo.microservice_silabo.infrastructure.SilaboRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;



@RestController
@RequestMapping("/silabo")
public class SilaboController {

    @Autowired
    private  SilaboRepository silaboRepository;

    @Autowired
    private SilaboService silaboService;

    @PostMapping("Crear/{cursoId}")
    public Mono<Silabo> crearSilabo(@PathVariable Integer cursoId){
        return silaboRepository.createSilabo(new Silabo(cursoId));
    }

    @PostMapping("Eliminar/{id}")
    public Mono<Void> eliminarSilabo(@PathVariable Long id){
        return silaboRepository.deleteSilabo(id);
    }


}
