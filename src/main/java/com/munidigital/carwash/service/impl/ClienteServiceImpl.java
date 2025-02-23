package com.munidigital.carwash.service.impl;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.repository.ClienteRepository;
import com.munidigital.carwash.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Log4j2
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<Cliente> crearCliente(ClienteCreateRequest request) {
        log.info("INIT: ClienteServiceImpl - crearCliente - {}", request);

        validateCliente(request);

        Cliente cliente = request.toEntity();

        Cliente clienteCreated = clienteRepository.saveCliente(cliente);

        log.info("END: ClienteServiceImpl - crearCliente - {}", request);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreated);
    }

    @Override
    public ResponseEntity<List<Cliente>> getClientes() {
        log.info("INIT: ClienteServiceImpl - getClientes");

        List<Cliente> clientes = clienteRepository.obtenerClientes();

        log.info("END: ClienteServiceImpl - getClientes - {}", clientes);

        if(clientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientes);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(clientes);
        }
    }

    private void validateCliente(ClienteCreateRequest cliente) {
        log.info("INIT: ClienteServiceImpl - validateCliente - {}", cliente);

        if(Objects.isNull(cliente)) {
            log.error("El cliente no puede ser nulo");
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }

        if(Objects.isNull(cliente.getNombre()) || cliente.getNombre().isEmpty()) {
            log.error("El nombre del cliente no puede estar vacio");
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacio");
        }

        if(Objects.isNull(cliente.getMail()) || cliente.getMail().isEmpty()) {
            log.error("El mail del cliente no puede estar vacio");
            throw new IllegalArgumentException("El mail del cliente no puede estar vacio");
        }

        if(Objects.isNull(cliente.getTelefono()) || cliente.getTelefono() <= 0) {
            log.error("El telefono debe ser valido");
            throw new IllegalArgumentException("El telefono debe ser valido");
        }

        log.info("END: ClienteServiceImpl - validateCliente - {}", cliente);
    }
}
