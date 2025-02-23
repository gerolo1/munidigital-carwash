package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<Cliente> crearCliente(@RequestBody ClienteCreateRequest request) {
        return clienteService.crearCliente(request);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        return clienteService.getClientes();
    }
}
