package com.munidigital.carwash.repository.impl;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.repository.VehiculoAtributoRepository;
import com.munidigital.carwash.repository.jpa.VehiculoAtributoRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Profile("db")
@Log4j2
public class VehiculoAtributoRepositoryDBImpl implements VehiculoAtributoRepository {

    private final VehiculoAtributoRepositoryJpa vehiculoAtributoRepositoryJpa;

    @Override
    public VehiculoAtributo saveVehiculoAtributo(VehiculoAtributo vehiculoAtributo) {
        log.info("INIT: VehiculoAtributoDBImpl - saveVehiculoAtributo - {}", vehiculoAtributo);

        VehiculoAtributo vehiculoAtributoCreated = vehiculoAtributoRepositoryJpa.save(vehiculoAtributo);

        log.info("END: VehiculoAtributoDBImpl - saveVehiculoAtributo - {}", vehiculoAtributo);
        return vehiculoAtributoCreated;
    }

    @Override
    public void deleteVehiculoAtributo(Long vehiculoAtributoId) {
        vehiculoAtributoRepositoryJpa.deleteById(vehiculoAtributoId);
    }

    @Override
    public List<VehiculoAtributo> obtenerAtributos() {
        return vehiculoAtributoRepositoryJpa.findAll();
    }
}
