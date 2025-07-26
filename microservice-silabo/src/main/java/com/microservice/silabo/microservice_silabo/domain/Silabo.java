package com.microservice.silabo.microservice_silabo.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor

@Table("silabo")
public class Silabo {
    @Id
    private Long id;
    private String cursoId;
    private String nombre;
    private String estrategiaDidactica;
    private String bibliografia;
    
}
