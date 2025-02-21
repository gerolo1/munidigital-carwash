package com.munidigital.carwash.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity @Getter @Setter
public class Cliente implements Serializable {

    @Id
    private Long clienteId;

    private String nombre;

    private String mail;

    private String telefono;
}
