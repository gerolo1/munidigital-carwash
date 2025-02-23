package com.munidigital.carwash.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.repository.TurnoRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("config")
@Log4j2
public class TurnoRepositoryConfigImpl implements TurnoRepository {

    private List<Turno> turnos;

    @Override
    public Turno saveTurno(Turno turno) {
        log.info("INIT: TurnoRepositoryConfigImpl - saveTurno - {}", turno);

        turno.setTurnoId(turnos.getLast().getTurnoId() + 1);

        turnos.add(turno);

        log.info("END: TurnoRepositoryConfigImpl - saveTurno - {}", turno);
        return turno;
    }

    @Override
    public Optional<Turno> buscarTurno(Long turnoId) {
        return turnos.stream()
                .filter(e -> e.getTurnoId().equals(turnoId))
                .findFirst();
    }

    @Override
    public List<Turno> obtenerTurnos() {
        return turnos;
    }

    @PostConstruct
    private void cargarTurnosConfig() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/turnos.json")) {
            turnos = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los turnos");
        }
    }
}
