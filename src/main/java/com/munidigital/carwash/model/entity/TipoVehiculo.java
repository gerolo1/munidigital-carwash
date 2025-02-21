package com.munidigital.carwash.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
public class TipoVehiculo implements Serializable {

    @Id
    private Long tipoVehiculoId;

    private String nombre;
}
