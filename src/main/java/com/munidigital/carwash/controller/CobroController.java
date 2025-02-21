package com.munidigital.carwash.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cobro")
public class CobroController {

    @PostMapping("/crear")
    public void crearCobro() {

    }
}
