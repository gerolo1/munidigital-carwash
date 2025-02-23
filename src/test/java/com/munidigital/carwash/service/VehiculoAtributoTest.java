package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.VehiculoAtributoCreateRequest;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.repository.VehiculoAtributoRepository;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.impl.VehiculoAtributoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehiculoAtributoTest {

    @InjectMocks
    private VehiculoAtributoServiceImpl vehiculoAtributoService;

    @Mock
    private VehiculoAtributoRepository vehiculoAtributoRepository;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Test
    void testCrearAtributoOK() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoId(1L);

        VehiculoAtributoCreateRequest request = new VehiculoAtributoCreateRequest();
        request.setVehiculo(vehiculo);
        request.setValor("Cama");
        request.setNombre("Cama");

        VehiculoAtributo atributo = request.toEntity();

        when(vehiculoRepository.buscarVehiculo(1L)).thenReturn(Optional.of(vehiculo));
        when(vehiculoAtributoRepository.saveVehiculoAtributo(atributo)).thenReturn(atributo);

        assertEquals(HttpStatus.CREATED, vehiculoAtributoService.crearAtributo(request).getStatusCode());
    }

    @Test
    void testCrearAtributoERROR() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoId(1L);

        VehiculoAtributoCreateRequest request = new VehiculoAtributoCreateRequest();
        request.setVehiculo(vehiculo);
        request.setValor("Cama");
        request.setNombre("Cama");

        when(vehiculoRepository.buscarVehiculo(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> vehiculoAtributoService.crearAtributo(request));
    }
}
