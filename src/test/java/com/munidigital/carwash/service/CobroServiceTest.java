package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import com.munidigital.carwash.model.entity.*;
import com.munidigital.carwash.repository.CobroRepository;
import com.munidigital.carwash.repository.TurnoRepository;
import com.munidigital.carwash.service.impl.CobroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CobroServiceTest {

    @InjectMocks
    private CobroServiceImpl cobroService;

    @Mock
    private CobroRepository cobroRepository;

    @Mock
    private TurnoRepository turnoRepository;

    @Test
    void testCrearCobroOK() {
        Turno turno = new Turno();
        turno.setEstado(EstadoTurno.Finalizado);
        turno.setTurnoId(1L);
        turno.setVehiculo(new Vehiculo());
        turno.setTipoServicio(TipoServicio.Completo);

        CobroCreateRequest request = new CobroCreateRequest();
        request.setMonto(1000L);
        request.setTurno(turno);

        Cobro cobro = request.toEntity();
        cobro.setFecha(LocalDateTime.now().withNano(0));

        when(turnoRepository.buscarTurno(1L)).thenReturn(Optional.of(turno));
        when(cobroRepository.saveCobro(cobro)).thenReturn(cobro);

        assertEquals(HttpStatus.CREATED, cobroService.crearCobro(request).getStatusCode());
    }

    @Test
    void testCrearCobroERROR() {
        Turno turno = new Turno();
        turno.setEstado(EstadoTurno.EnProceso);
        turno.setTurnoId(1L);
        turno.setVehiculo(new Vehiculo());
        turno.setTipoServicio(TipoServicio.Completo);

        CobroCreateRequest request = new CobroCreateRequest();
        request.setMonto(1000L);
        request.setTurno(turno);

        assertThrows(IllegalArgumentException.class, () -> cobroService.crearCobro(request));
    }
}
