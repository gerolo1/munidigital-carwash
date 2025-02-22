package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import jakarta.transaction.Transactional;

public interface VehiculoService {

    @Transactional
    void crearVehiculo(VehiculoCreateRequest vehiculo);
}
