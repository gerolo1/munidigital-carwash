package com.munidigital.carwash.repository.impl;

import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.repository.CobroRepository;
import com.munidigital.carwash.repository.jpa.CobroRepositoryJpa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
@Profile("db")
@Log4j2
public class CobroRepositoryDBImpl implements CobroRepository {

    private final CobroRepositoryJpa cobroRepositoryJpa;

    @Override
    public Cobro saveCobro(Cobro cobro) {
        log.info("INIT: CobroRepositoryDBImpl - saveCobro - {}", cobro);

        Cobro clienteCreated = cobroRepositoryJpa.save(cobro);

        log.info("END: CobroRepositoryDBImpl - saveCobro - {}", cobro);
        return clienteCreated;
    }

    @Override
    public List<Cobro> obtenerCobros() {
        return cobroRepositoryJpa.findAll();
    }
}
