package com.munidigital.carwash.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class VehiculoAtributo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehiculoAtributoId;

    @ManyToOne
    private Vehiculo vehiculo;

    private String nombre;

    private String valor;
}
