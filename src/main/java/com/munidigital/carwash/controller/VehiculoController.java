package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@AllArgsConstructor
public class VehiculoController {

    private VehiculoService vehiculoService;

    @PostMapping("/crear")
    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody VehiculoCreateRequest request) {
        return vehiculoService.crearVehiculo(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Vehiculo>> obtenerVehiculos() {
        return vehiculoService.getVehiculos();
    }
}
