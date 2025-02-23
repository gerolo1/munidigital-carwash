package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CobroService {

    @Transactional
    ResponseEntity<Cobro> crearCobro(CobroCreateRequest cobro);

    ResponseEntity<List<Cobro>> getCobros();
}
