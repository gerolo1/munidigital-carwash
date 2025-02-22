package com.munidigital.carwash.model.dto;

import com.munidigital.carwash.model.entity.EstadoTurno;
import com.munidigital.carwash.model.entity.TipoServicio;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.model.entity.Vehiculo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TurnoCreateRequest implements Serializable {

    private TipoServicio tipoServicio;

    private EstadoTurno estado;

    private Vehiculo vehiculo;

    private LocalDateTime fecha;

    public Turno toEntity() {
        Turno turno = new Turno();

        turno.setTipoServicio(tipoServicio);
        turno.setEstado(estado);
        turno.setVehiculo(vehiculo);
        turno.setFecha(fecha);

        return turno;
    }
}
