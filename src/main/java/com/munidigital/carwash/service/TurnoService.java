package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Turno;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TurnoService {

    @Transactional
    ResponseEntity<Turno> crearTurno(TurnoCreateRequest turno);

    ResponseEntity<List<Turno>> getTurnos();
}
