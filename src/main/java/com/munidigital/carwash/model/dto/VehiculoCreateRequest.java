package com.munidigital.carwash.model.dto;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.TipoVehiculo;
import com.munidigital.carwash.model.entity.Vehiculo;
import lombok.Data;

import java.io.Serializable;

@Data
public class VehiculoCreateRequest implements Serializable {

    private String modelo;

    private String matricula;

    private TipoVehiculo tipoVehiculo;

    private Cliente cliente;

    public Vehiculo toEntity() {
        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setModelo(modelo);
        vehiculo.setMatricula(matricula);
        vehiculo.setTipo(tipoVehiculo);
        vehiculo.setCliente(cliente);

        return vehiculo;
    }
}
