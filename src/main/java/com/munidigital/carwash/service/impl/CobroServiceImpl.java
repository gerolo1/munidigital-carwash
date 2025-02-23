package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.model.entity.EstadoTurno;
import com.munidigital.carwash.repository.CobroRepository;
import com.munidigital.carwash.repository.TurnoRepository;
import com.munidigital.carwash.service.CobroService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class CobroServiceImpl implements CobroService {

    private final CobroRepository cobroRepository;

    private final TurnoRepository turnoRepository;

    @Override
    public ResponseEntity<Cobro> crearCobro(CobroCreateRequest request) {
        log.info("INIT: CobroServiceImpl - crearCobro - {}", request);

        validateCobro(request);

        Cobro cobro = request.toEntity();

        cobro.setFecha(LocalDateTime.now().withNano(0));

        Cobro cobroCreated = cobroRepository.saveCobro(cobro);

        log.info("END: CobroServiceImpl - crearCobro - {}", request);

        return ResponseEntity.status(HttpStatus.CREATED).body(cobroCreated);
    }

    @Override
    public ResponseEntity<List<Cobro>> getCobros() {
        log.info("INIT: CobroServiceImpl - getCobros");

        List<Cobro> cobros = cobroRepository.obtenerCobros();

        log.info("END: CobroServiceImpl - getCobros - {}", cobros);

        if(cobros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cobros);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cobros);
        }
    }

    private void validateCobro(CobroCreateRequest cobro) {
        log.info("INIT: CobroServiceImpl - validateCobro - {}", cobro);

        if(Objects.isNull(cobro)) {
            log.error("El cobro no puede ser nulo");
            throw new IllegalArgumentException("El cobro no puede ser nulo");
        }

        if(Objects.isNull(cobro.getTurno())) {
            log.error("El turno del cobro no puede estar vacio");
            throw new IllegalArgumentException("El turno del cobro no puede estar vacio");
        }

        if(Objects.isNull(cobro.getMonto()) || cobro.getMonto() < 0) {
            log.error("El monto del cobro debe ser valido");
            throw new IllegalArgumentException("El monto del cobro debe ser valido");
        }

        if(Objects.isNull(cobro.getTurno().getEstado())) {
            log.error("El turno debe ser valido");
            throw new IllegalArgumentException("El turno debe ser valido");
        }

        if(!cobro.getTurno().getEstado().equals(EstadoTurno.Finalizado)) {
            log.error("No se puede realizar el cobro de un turno no finalizado");
            throw new IllegalArgumentException("No se puede realizar el cobro de un turno no finalizado");
        }

        if(turnoRepository.buscarTurno(cobro.getTurno().getTurnoId()).isEmpty()) {
            log.error("El turno no se encuentra registrado");
            throw new IllegalArgumentException("El turno no se encuentra registrado");
        }

        log.info("END: CobroServiceImpl - validateCobro - {}", cobro);
    }
}
