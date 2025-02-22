package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
@AllArgsConstructor
public class VehiculoController {

    private VehiculoService vehiculoService;

    @PostMapping("/crear")
    public void crearVehiculo(@RequestBody VehiculoCreateRequest request) {
        vehiculoService.crearVehiculo(request);
    }
}
