package com.munidigital.carwash.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.Cobro;
import com.munidigital.carwash.repository.CobroRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
@Profile("config")
@Log4j2
public class CobroRepositoryConfigImpl implements CobroRepository {

    private List<Cobro> cobros;

    @Override
    public Cobro saveCobro(Cobro cobro) {
        log.info("INIT: CobroRepositoryConfigImpl - saveCobro - {}", cobro);

        cobro.setCobroId(cobros.getLast().getCobroId() + 1);

        cobros.add(cobro);

        log.info("END: CobroRepositoryConfigImpl - saveCobro - {}", cobro);
        return cobro;
    }

    @Override
    public List<Cobro> obtenerCobros() {
        return cobros;
    }

    @PostConstruct
    private void cargarCobrosConfig() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/cobros.json")) {
            cobros = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los cobros");
        }
    }
}
