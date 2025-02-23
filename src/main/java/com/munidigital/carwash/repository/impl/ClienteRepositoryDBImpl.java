package com.munidigital.carwash.repository.impl;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.repository.ClienteRepository;
import com.munidigital.carwash.repository.jpa.ClienteRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Profile("db")
@Log4j2
public class ClienteRepositoryDBImpl implements ClienteRepository {

    private final ClienteRepositoryJpa clienteRepositoryJpa;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        log.info("INIT: ClienteRepositoryDBImpl - saveCliente - {}", cliente);

        Cliente clienteCreated = clienteRepositoryJpa.save(cliente);

        log.info("END: ClienteRepositoryDBImpl - saveCliente - {}", cliente);
        return clienteCreated;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepositoryJpa.findAll();
    }
}
