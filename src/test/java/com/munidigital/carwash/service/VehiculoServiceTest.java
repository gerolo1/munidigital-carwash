package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.VehiculoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.TipoVehiculo;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.impl.VehiculoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {

    @InjectMocks
    private VehiculoServiceImpl vehiculoService;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Test
    void testCrearVehiculoOK() {
        VehiculoCreateRequest request = new VehiculoCreateRequest();
        request.setTipoVehiculo(new TipoVehiculo());
        request.setMatricula("123123");
        request.setCliente(new Cliente());
        request.setModelo("123123");

        Vehiculo vehiculo = request.toEntity();

        when(vehiculoRepository.saveVehiculo(vehiculo)).thenReturn(vehiculo);

        assertEquals(HttpStatus.CREATED, vehiculoService.crearVehiculo(request).getStatusCode());
    }

    @Test
    void testCrearVehiculoERROR() {
        VehiculoCreateRequest request = new VehiculoCreateRequest();
        request.setTipoVehiculo(new TipoVehiculo());
        request.setMatricula("");
        request.setCliente(new Cliente());
        request.setModelo("");

        assertThrows(IllegalArgumentException.class, () -> vehiculoService.crearVehiculo(request));
    }
}
