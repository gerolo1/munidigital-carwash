package com.munidigital.carwash.model.dto;

import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import lombok.Data;

@Data
public class VehiculoAtributoCreateRequest {

    private Vehiculo vehiculo;

    private String nombre;

    private String valor;

    public VehiculoAtributo toEntity() {
        VehiculoAtributo vehiculoAtributo = new VehiculoAtributo();

        vehiculoAtributo.setVehiculo(vehiculo);
        vehiculoAtributo.setNombre(nombre);
        vehiculoAtributo.setValor(valor);

        return vehiculoAtributo;
    }
}
