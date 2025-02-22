package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ClienteService {

    @Transactional
    void crearCliente(ClienteCreateRequest cliente);

    List<Cliente> getClientes();
}
