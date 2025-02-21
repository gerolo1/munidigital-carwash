package com.munidigital.carwash.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Turno implements Serializable {

    @Id
    private Long turnoId;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoServicio tipoServicio;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;

    @ManyToOne
    private Vehiculo vehiculo;
}
