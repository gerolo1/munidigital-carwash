package com.munidigital.carwash.model.dto;

import com.munidigital.carwash.model.entity.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClienteCreateRequest implements Serializable {

    private String nombre;

    private String mail;

    private Long telefono;

    public Cliente toEntity() {
        Cliente cliente = new Cliente();

        cliente.setNombre(nombre);
        cliente.setMail(mail);
        cliente.setTelefono(telefono);

        return cliente;
    }
}
