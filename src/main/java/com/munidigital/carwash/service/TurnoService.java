package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import jakarta.transaction.Transactional;

public interface TurnoService {

    @Transactional
    void crearTurno(TurnoCreateRequest turno);
}
