package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Cliente;

import java.util.List;

public interface ClienteRepository {

    Cliente saveCliente(Cliente cliente);

    List<Cliente> obtenerClientes();
}
