package com.munidigital.carwash.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.VehiculoAtributo;
import com.munidigital.carwash.repository.VehiculoAtributoRepository;
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
public class VehiculoAtributoRepositoryConfigImpl implements VehiculoAtributoRepository {

    private List<VehiculoAtributo> atributos;

    @Override
    public VehiculoAtributo saveVehiculoAtributo(VehiculoAtributo vehiculoAtributo) {
        log.info("INIT: VehiculoAtributoConfigImpl - saveVehiculoAtributo - {}", vehiculoAtributo);

        vehiculoAtributo.setVehiculoAtributoId(atributos.getLast().getVehiculoAtributoId() + 1);

        atributos.add(vehiculoAtributo);

        log.info("END: VehiculoAtributoConfigImpl - saveVehiculoAtributo - {}", vehiculoAtributo);
        return vehiculoAtributo;
    }

    @Override
    public void deleteVehiculoAtributo(Long vehiculoAtributoId) {
        atributos.remove(atributos.stream()
                .filter(e -> e.getVehiculoAtributoId().equals(vehiculoAtributoId))
                .findFirst()
                .orElse(null));
    }

    @Override
    public List<VehiculoAtributo> obtenerAtributos() {
        return atributos;
    }

    @PostConstruct
    private void cargarAtributosConfig() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/atributos.json")) {
            atributos = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los atributos");
        }
    }
}
