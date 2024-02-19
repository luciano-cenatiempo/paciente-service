package com.lcena.pacientesservicio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter @Setter
public class Paciente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dni;
    private String nombre;
    private String apellido;

    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    private String telefono;

    public Paciente() {
    }

    public Paciente(Long id, Integer dni, String nombre, String apellido, Date fechaNac, String telefono) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
    }
}
