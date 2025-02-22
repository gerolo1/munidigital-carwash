package com.munidigital.carwash.controller;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/crear")
    public void crearCliente(@RequestBody ClienteCreateRequest request) {
        clienteService.crearCliente(request);
    }

    @GetMapping("/getAll")
    public List<Cliente> obtenerClientes() {
        return clienteService.getClientes();
    }
}
