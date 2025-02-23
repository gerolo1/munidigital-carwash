package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Vehiculo;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehiculoService {

    @Transactional
    ResponseEntity<Vehiculo> crearVehiculo(VehiculoCreateRequest vehiculo);

    ResponseEntity<List<Vehiculo>> getVehiculos();
}
