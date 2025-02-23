package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.service.CobroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cobro")
@AllArgsConstructor
public class CobroController {

    private final CobroService cobroService;

    @PostMapping("/crear")
    public ResponseEntity<Cobro> crearCobro(@RequestBody CobroCreateRequest request) {
        return cobroService.crearCobro(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cobro>> obtenerCobros() {
        return cobroService.getCobros();
    }
}
