package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.VehiculoAtributo;

import java.util.List;

public interface VehiculoAtributoRepository {

    VehiculoAtributo saveVehiculoAtributo(VehiculoAtributo vehiculoAtributo);

    void deleteVehiculoAtributo(Long vehiculoAtributoId);

    List<VehiculoAtributo> obtenerAtributos();
}
