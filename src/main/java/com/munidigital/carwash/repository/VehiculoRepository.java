package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository {

    Vehiculo saveVehiculo(Vehiculo vehiculo);

    Optional<Vehiculo> buscarVehiculo(Long vehiculoId);

    List<Vehiculo> obtenerVehiculos();
}
