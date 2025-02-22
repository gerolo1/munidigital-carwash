package com.munidigital.carwash.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class TipoVehiculo implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoVehiculoId;

    private String nombre;
}
