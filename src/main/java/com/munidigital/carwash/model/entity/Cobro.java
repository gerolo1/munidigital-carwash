package com.munidigital.carwash.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Cobro implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cobroId;

    private Long monto;

    private LocalDateTime fecha;

    @ManyToOne
    private Turno turno;
}
