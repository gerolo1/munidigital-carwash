package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.VehiculoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public void crearVehiculo(VehiculoCreateRequest request) {
        log.info("INIT: VehiculoServiceImpl - crearVehiculo - {}", request);

        validateVehiculo(request);

        Vehiculo vehiculo = request.toEntity();

        log.info("INIT: VehiculoRepository - save - {}", vehiculo);
        vehiculoRepository.save(vehiculo);
        log.info("END: VehiculoRepository - save - {}", vehiculo);

        log.info("END: VehiculoServiceImpl - crearVehiculo - {}", request);
    }

    private void validateVehiculo(VehiculoCreateRequest vehiculo) {
        log.info("INIT: VehiculoServiceImpl - validateVehiculo - {}", vehiculo);

        if(Objects.isNull(vehiculo)) {
            log.error("El vehiculo no puede ser nulo");
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }

        if(Objects.isNull(vehiculo.getModelo()) || vehiculo.getModelo().isEmpty()) {
            log.error("El modelo del vehiculo no puede estar vacio");
            throw new IllegalArgumentException("El modelo del vehiculo no puede estar vacio");
        }

        if(Objects.isNull(vehiculo.getMatricula()) || vehiculo.getMatricula().isEmpty()) {
            log.error("La matricula del vehiculo no puede estar vacia");
            throw new IllegalArgumentException("La matricula del vehiculo no puede estar vacia");
        }

        if(Objects.isNull(vehiculo.getTipoVehiculo())) {
            log.error("El tipo de vehiculo no puede estar vacio");
            throw new IllegalArgumentException("El tipo de vehiculo no puede estar vacio");
        }

        if(Objects.isNull(vehiculo.getCliente())) {
            log.error("El cliente no puede estar vacio");
            throw new IllegalArgumentException("El cliente no puede estar vacio");
        }

        log.info("END: VehiculoServiceImpl - validateVehiculo - {}", vehiculo);
    }
}
