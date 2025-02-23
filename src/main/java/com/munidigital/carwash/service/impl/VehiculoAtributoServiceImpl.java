package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.VehiculoAtributoCreateRequest;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.repository.VehiculoAtributoRepository;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.VehiculoAtributoService;
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
public class VehiculoAtributoServiceImpl implements VehiculoAtributoService {

    private final VehiculoRepository vehiculoRepository;

    private final VehiculoAtributoRepository vehiculoAtributoRepository;

    @Override
    public ResponseEntity<VehiculoAtributo> crearAtributo(VehiculoAtributoCreateRequest request) {
        log.info("INIT: VehiculoAtributoServiceImpl - crearAtributo - {}", request);

        validateAtributo(request);

        VehiculoAtributo vehiculoAtributo = request.toEntity();

        VehiculoAtributo vehiculoAtributoCreated = vehiculoAtributoRepository.saveVehiculoAtributo(vehiculoAtributo);

        log.info("END: VehiculoAtributoServiceImpl - crearAtributo - {}", request);

        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoAtributoCreated);
    }

    @Override
    public ResponseEntity<String> borrarAtributo(Long vehiculoAtributoId) {
        log.info("INIT: VehiculoAtributoServiceImpl - borrarAtributo - ID: {}", vehiculoAtributoId);

        vehiculoAtributoRepository.deleteVehiculoAtributo(vehiculoAtributoId);

        log.info("INIT: VehiculoAtributoServiceImpl - borrarAtributo - ID: {}", vehiculoAtributoId);
        return ResponseEntity.status(HttpStatus.OK).body("Vehiculo borrado correctamente");
    }

    @Override
    public ResponseEntity<List<VehiculoAtributo>> getAtributos() {
        log.info("INIT: VehiculoAtributoServiceImpl - getAtributos");

        List<VehiculoAtributo> vehiculoAtributos = vehiculoAtributoRepository.obtenerAtributos();

        log.info("END: VehiculoAtributoServiceImpl - getAtributos - {}", vehiculoAtributos);

        if(vehiculoAtributos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(vehiculoAtributos);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(vehiculoAtributos);
        }
    }

    private void validateAtributo(VehiculoAtributoCreateRequest vehiculoAtributo) {
        log.info("INIT: VehiculoAtributoServiceImpl - validateAtributo - {}", vehiculoAtributo);

        if(Objects.isNull(vehiculoAtributo)) {
            log.error("El atributo no puede ser nulo");
            throw new IllegalArgumentException("El atributo no puede ser nulo");
        }

        if(Objects.isNull(vehiculoAtributo.getVehiculo())) {
            log.error("El vehiculo no puede estar vacio");
            throw new IllegalArgumentException("El vehiculo no puede estar vacio");
        }

        if(Objects.isNull(vehiculoAtributo.getNombre()) || vehiculoAtributo.getNombre().isEmpty()) {
            log.error("El nombre del atributo no puede estar vacio");
            throw new IllegalArgumentException("El nombre del atributo no puede estar vacio");
        }

        if(Objects.isNull(vehiculoAtributo.getValor()) || vehiculoAtributo.getValor().isEmpty()) {
            log.error("El valor del atributo no puede estar vacio");
            throw new IllegalArgumentException("El valor del atributo no puede estar vacio");
        }

        if(vehiculoRepository.buscarVehiculo(vehiculoAtributo.getVehiculo().getVehiculoId()).isEmpty()) {
            log.error("El vehiculo no se encuentra registrado");
            throw new IllegalArgumentException("El vehiculo no se encuentra registrado");
        }

        log.info("END: VehiculoAtributoServiceImpl - validateAtributo - {}", vehiculoAtributo);
    }
}
