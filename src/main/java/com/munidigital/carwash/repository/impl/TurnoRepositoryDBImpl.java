package com.munidigital.carwash.repository.impl;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.repository.TurnoRepository;
import com.munidigital.carwash.repository.jpa.TurnoRepositoryJpa;
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
public class TurnoRepositoryDBImpl implements TurnoRepository {

    private final TurnoRepositoryJpa turnoRepositoryJpa;

    @Override
    public Turno saveTurno(Turno turno) {
        log.info("INIT: TurnoRepositoryDBImpl - saveTurno - {}", turno);

        Turno turnoCreated = turnoRepositoryJpa.save(turno);

        log.info("END: TurnoRepositoryDBImpl - saveTurno - {}", turno);
        return turnoCreated;
    }

    @Override
    public Optional<Turno> buscarTurno(Long turnoId) {
        return turnoRepositoryJpa.findById(turnoId);
    }

    @Override
    public List<Turno> obtenerTurnos() {
        return turnoRepositoryJpa.findAll();
    }
}
