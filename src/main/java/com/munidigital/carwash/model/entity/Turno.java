package com.munidigital.carwash.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
