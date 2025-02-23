package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.ClienteCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.repository.ClienteRepository;
import com.munidigital.carwash.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void testObtenerListadoClientes() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("Test");
        cliente.setMail("Test@test.com");
        cliente.setTelefono(1123456789L);
        List<Cliente> clientes = List.of(cliente);

        when(clienteRepository.obtenerClientes()).thenReturn(clientes);

        assertEquals(HttpStatus.OK, clienteService.getClientes().getStatusCode());
    }

    @Test
    void testObtenerListadoClientesVacio() {
        when(clienteRepository.obtenerClientes()).thenReturn(Collections.emptyList());

        assertEquals(HttpStatus.NO_CONTENT, clienteService.getClientes().getStatusCode());
    }

    @Test
    void testCrearClienteOK() {
        ClienteCreateRequest request = new ClienteCreateRequest();
        request.setNombre("Test");
        request.setMail("Test@test.com");
        request.setTelefono(1123456789L);

        Cliente cliente = request.toEntity();

        when(clienteRepository.saveCliente(cliente)).thenReturn(cliente);

        assertEquals(HttpStatus.CREATED, clienteService.crearCliente(request).getStatusCode());
    }

    @Test
    void testCrearClienteERROR() {
        ClienteCreateRequest request = new ClienteCreateRequest();
        request.setNombre("Test");
        request.setMail("Test@test.com");
        request.setTelefono(0L);

        assertThrows(IllegalArgumentException.class, () -> clienteService.crearCliente(request));
    }
}
