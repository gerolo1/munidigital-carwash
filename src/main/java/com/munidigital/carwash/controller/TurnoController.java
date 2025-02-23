package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
@AllArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoCreateRequest request) {
        return turnoService.crearTurno(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Turno>> obtenerTurnos() {
        return turnoService.getTurnos();
    }
}
