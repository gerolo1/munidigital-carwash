package com.munidigital.carwash.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class Vehiculo implements Serializable {

    @Id
    private Long vehiculoId;

    private String modelo;

    private String matricula;

    @ManyToOne
    private TipoVehiculo tipo;

    @ManyToOne
    private Cliente cliente;
}
