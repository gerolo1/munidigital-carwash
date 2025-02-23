package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoRepository {

    Turno saveTurno(Turno turno);

    Optional<Turno> buscarTurno(Long turnoId);

    List<Turno> obtenerTurnos();
}
