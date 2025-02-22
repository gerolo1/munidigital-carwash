package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.CobroCreateRequest;
import jakarta.transaction.Transactional;

public interface CobroService {

    @Transactional
    void crearCobro(CobroCreateRequest cobro);
}
