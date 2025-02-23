package com.munidigital.carwash.service;

import com.munidigital.carwash.model.dto.VehiculoAtributoCreateRequest;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehiculoAtributoService {

    @Transactional
    ResponseEntity<VehiculoAtributo> crearAtributo(VehiculoAtributoCreateRequest vehiculoAtributo);

    @Transactional
    ResponseEntity<String> borrarAtributo(Long vehiculoAtributoId);

    ResponseEntity<List<VehiculoAtributo>> getAtributos();
}
