package com.microservice.silabo.microservice_silabo.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor

@Table("curso")
public class Curso {
    @Id
    private Long id;
    private String nombre;
    private String codigo;
    private String estado;
    private String sumilla;
    
}
