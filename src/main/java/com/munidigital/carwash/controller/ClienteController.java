package com.munidigital.carwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping("/crear")
    public void crearCliente() {

    }

    @GetMapping("/getOne")
    public void obtenerCliente() {

    }

    @GetMapping("/getAll")
    public void obtenerClientes() {

    }
}
