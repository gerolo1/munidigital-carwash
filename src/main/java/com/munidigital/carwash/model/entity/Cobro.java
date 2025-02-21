package com.munidigital.carwash.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Cobro implements Serializable {

    @Id
    private Long cobroId;

    private Long monto;

    private LocalDate fecha;

    @ManyToOne
    private Turno turno;
}
