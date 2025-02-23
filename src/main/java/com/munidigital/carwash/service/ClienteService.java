package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    @Transactional
    ResponseEntity<Cliente> crearCliente(ClienteCreateRequest cliente);

    ResponseEntity<List<Cliente>> getClientes();
}
