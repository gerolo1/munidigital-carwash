package com.munidigital.carwash.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.munidigital.carwash.model.entity.EstadoTurno;
import com.munidigital.carwash.model.entity.TipoServicio;
import com.munidigital.carwash.model.entity.Turno;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TurnoCreateRequest implements Serializable {

    private TipoServicio tipoServicio;

    private EstadoTurno estado;

    private Vehiculo vehiculo;

    private String fecha;

    public Turno toEntity() {
        Turno turno = new Turno();

        turno.setTipoServicio(tipoServicio);
        turno.setEstado(estado);
        turno.setVehiculo(vehiculo);
        turno.setFecha(DateUtils.parse(fecha));

        return turno;
    }
}
