package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.TurnoCreateRequest;
import com.munidigital.carwash.model.dto.VehiculoAtributoCreateRequest;
import com.munidigital.carwash.model.entity.*;
import com.munidigital.carwash.repository.TurnoRepository;
import com.munidigital.carwash.repository.VehiculoAtributoRepository;
import com.munidigital.carwash.repository.VehiculoRepository;
import com.munidigital.carwash.service.impl.TurnoServiceImpl;
import com.munidigital.carwash.service.impl.VehiculoAtributoServiceImpl;
import com.munidigital.carwash.utils.DateUtils;
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
public class TurnoServiceTest {

    @InjectMocks
    private TurnoServiceImpl turnoService;

    @Mock
    private TurnoRepository turnoRepository;

    @Mock
    private VehiculoRepository vehiculoRepository;

    @Test
    void testCrearTurnoOK() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoId(1L);

        TurnoCreateRequest request = new TurnoCreateRequest();
        request.setVehiculo(vehiculo);
        request.setEstado(EstadoTurno.Finalizado);
        request.setTipoServicio(TipoServicio.Completo);
        request.setFecha("2026-02-23 15:30:00");

        Turno turno = request.toEntity();

        when(vehiculoRepository.buscarVehiculo(1L)).thenReturn(Optional.of(vehiculo));
        when(turnoRepository.saveTurno(turno)).thenReturn(turno);

        assertEquals(HttpStatus.CREATED, turnoService.crearTurno(request).getStatusCode());
    }

    @Test
    void testCrearTurnoERROR() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoId(1L);

        TurnoCreateRequest request = new TurnoCreateRequest();
        request.setVehiculo(vehiculo);
        request.setEstado(EstadoTurno.Finalizado);
        request.setTipoServicio(TipoServicio.Completo);

        assertThrows(IllegalArgumentException.class, () -> turnoService.crearTurno(request));
    }
}
