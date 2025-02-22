package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.model.entity.EstadoTurno;
import com.munidigital.carwash.repository.CobroRepository;
import com.munidigital.carwash.service.CobroService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class CobroServiceImpl implements CobroService {

    private final CobroRepository cobroRepository;

    @Override
    public void crearCobro(CobroCreateRequest request) {
        log.info("INIT: CobroServiceImpl - crearCobro - {}", request);

        validateCobro(request);

        Cobro cobro = request.toEntity();

        cobro.setFecha(LocalDate.now());

        log.info("INIT: CobroRepository - save - {}", cobro);
        cobroRepository.save(cobro);
        log.info("END: CobroRepository - save - {}", cobro);

        log.info("END: CobroServiceImpl - crearCobro - {}", request);
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

        if(!cobro.getTurno().getEstado().equals(EstadoTurno.Finalizado)) {
            log.error("No se puede realizar el cobro de un turno no finalizado");
            throw new IllegalArgumentException("No se puede realizar el cobro de un turno no finalizado");
        }

        log.info("END: CobroServiceImpl - validateCobro - {}", cobro);
    }
}
