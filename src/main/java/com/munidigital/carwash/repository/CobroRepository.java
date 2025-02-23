package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;

import java.util.List;

public interface CobroRepository {

    Cobro saveCobro(Cobro cobro);

    List<Cobro> obtenerCobros();
}
