package com.munidigital.carwash.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.repository.ClienteRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
@Profile("config")
@Log4j2
public class ClienteRepositoryConfigImpl implements ClienteRepository {

    private List<Cliente> clientes;

    @Override
    public Cliente saveCliente(Cliente cliente) {
        log.info("INIT: ClienteRepositoryConfigImpl - saveCliente - {}", cliente);

        cliente.setClienteId(clientes.getLast().getClienteId() + 1);

        clientes.add(cliente);

        log.info("END: ClienteRepositoryConfigImpl - saveCliente - {}", cliente);
        return cliente;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    @PostConstruct
    private void cargarClientesConfig() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/clientes.json")) {
            clientes = mapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los clientes");
        }
    }
}
