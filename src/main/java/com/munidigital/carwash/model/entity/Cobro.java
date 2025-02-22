package com.munidigital.carwash.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Cobro implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cobroId;

    private Long monto;

    private LocalDate fecha;

    @ManyToOne
    private Turno turno;
}
