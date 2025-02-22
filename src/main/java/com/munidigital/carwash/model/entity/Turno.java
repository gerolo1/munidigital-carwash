package com.munidigital.carwash.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Turno implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long turnoId;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoServicio tipoServicio;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne
    private Vehiculo vehiculo;
}
