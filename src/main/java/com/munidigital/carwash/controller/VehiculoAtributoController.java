package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.VehiculoAtributoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.service.VehiculoAtributoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atributo")
@AllArgsConstructor
public class VehiculoAtributoController {

    private final VehiculoAtributoService vehiculoAtributoService;

    @PostMapping("/crear")
    public ResponseEntity<VehiculoAtributo> crearVehiculo(@RequestBody VehiculoAtributoCreateRequest request) {
        return vehiculoAtributoService.crearAtributo(request);
    }

    @DeleteMapping("/borrar")
    public ResponseEntity<String> borrarAtributo(@RequestParam Long vehiculoAtributoId) {
        return vehiculoAtributoService.borrarAtributo(vehiculoAtributoId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VehiculoAtributo>> obtenerAtributos() {
        return vehiculoAtributoService.getAtributos();
    }
}
