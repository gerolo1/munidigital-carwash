package com.munidigital.carwash.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Vehiculo implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculoId;

    private String modelo;

    private String matricula;

    @ManyToOne
    private TipoVehiculo tipo;

    @ManyToOne
    private Cliente cliente;
}
