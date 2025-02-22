package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import com.munidigital.carwash.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
@AllArgsConstructor
public class TurnoController {

    private final TurnoService turnoService;

    @PostMapping("/crear")
    public void crearTurno(@RequestBody TurnoCreateRequest request) {
        turnoService.crearTurno(request);
    }
}
