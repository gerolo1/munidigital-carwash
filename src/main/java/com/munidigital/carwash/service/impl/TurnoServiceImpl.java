package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.repository.TurnoRepository;
import com.munidigital.carwash.service.TurnoService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;

    @Override
    public void crearTurno(TurnoCreateRequest request) {
        log.info("INIT: TurnoServiceImpl - crearTurno - {}", request);

        validateTurno(request);

        Turno turno = request.toEntity();

        log.info("INIT: TurnoRepository - save - {}", turno);
        turnoRepository.save(turno);
        log.info("END: TurnoRepository - save - {}", turno);

        log.info("END: TurnoServiceImpl - crearTurno - {}", request);
    }

    private void validateTurno(TurnoCreateRequest turno) {
        log.info("INIT: TurnoServiceImpl - validateTurno - {}", turno);

        if(Objects.isNull(turno)) {
            log.error("El turno no puede ser nulo");
            throw new IllegalArgumentException("El turno no puede ser nulo");
        }

        if(Objects.isNull(turno.getTipoServicio())) {
            log.error("El tipo de servicio no puede estar vacio");
            throw new IllegalArgumentException("El tipo de servicio no puede estar vacio");
        }

        if(Objects.isNull(turno.getEstado())) {
            log.error("El estado del turno no puede estar vacio");
            throw new IllegalArgumentException("El estado del turno no puede estar vacio");
        }

        if(Objects.isNull(turno.getVehiculo())) {
            log.error("El vehiculo no puede estar vacio");
            throw new IllegalArgumentException("El vehiculo no puede estar vacio");
        }

        if(Objects.isNull(turno.getFecha())) {
            log.error("La fecha no puede estar vacia");
            throw new IllegalArgumentException("La fecha no puede estar vacia");
        }

        if(turno.getFecha().isBefore(LocalDateTime.now())) {
            log.error("La fecha debe ser valida");
            throw new IllegalArgumentException("La fecha debe ser valida");
        }

        log.info("END: TurnoServiceImpl - validateTurno - {}", turno);
    }
}
