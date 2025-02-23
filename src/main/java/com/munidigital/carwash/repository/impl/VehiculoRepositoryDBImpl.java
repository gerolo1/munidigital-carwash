package com.munidigital.carwash.repository.impl;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.repository.jpa.VehiculoRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Profile("db")
@Log4j2
public class VehiculoRepositoryDBImpl implements VehiculoRepository {

    private final VehiculoRepositoryJpa vehiculoRepositoryJpa;

    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        log.info("INIT: VehiculoRepositoryDBImpl - saveVehiculo - {}", vehiculo);

        Vehiculo vehiculoCreated = vehiculoRepositoryJpa.save(vehiculo);

        log.info("END: VehiculoRepositoryDBImpl - saveVehiculo - {}", vehiculo);
        return vehiculoCreated;
    }

    @Override
    public Optional<Vehiculo> buscarVehiculo(Long vehiculoId) {
        return vehiculoRepositoryJpa.findById(vehiculoId);
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepositoryJpa.findAll();
    }
}
