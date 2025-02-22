package com.munidigital.carwash.model.dto;

import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.model.entity.Turno;
import lombok.Data;

import java.io.Serializable;

@Data
public class CobroCreateRequest implements Serializable {

    private Long monto;

    private Turno turno;

    public Cobro toEntity() {
        Cobro cobro = new Cobro();

        cobro.setMonto(monto);
        cobro.setTurno(turno);

        return cobro;
    }
}
