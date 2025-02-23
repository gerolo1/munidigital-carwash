package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.VehiculoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Override
    public ResponseEntity<Vehiculo> crearVehiculo(VehiculoCreateRequest request) {
        log.info("INIT: VehiculoServiceImpl - crearVehiculo - {}", request);

        validateVehiculo(request);

        Vehiculo vehiculo = request.toEntity();

        Vehiculo vehiculoCreated = vehiculoRepository.saveVehiculo(vehiculo);

        log.info("END: VehiculoServiceImpl - crearVehiculo - {}", request);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoCreated);
    }

    @Override
    public ResponseEntity<List<Vehiculo>> getVehiculos() {
        log.info("INIT: VehiculoServiceImpl - getVehiculos");

        List<Vehiculo> vehiculos = vehiculoRepository.obtenerVehiculos();

        log.info("END: VehiculoServiceImpl - getVehiculos - {}", vehiculos);

        if(vehiculos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vehiculos);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(vehiculos);
        }
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
