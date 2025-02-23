package com.munidigital.carwash.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.munidigital.carwash.model.entity.Cliente;
import com.munidigital.carwash.model.entity.TipoVehiculo;
import com.munidigital.carwash.model.entity.Vehiculo;
import com.munidigital.carwash.repository.VehiculoRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("config")
@Log4j2
public class VehiculoRepositoryConfigImpl implements VehiculoRepository {

    private List<Vehiculo> vehiculos;

    private List<TipoVehiculo> tipos;


    @Override
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        log.info("INIT: VehiculoRepositoryConfigImpl - saveVehiculo - {}", vehiculo);

        vehiculo.setVehiculoId(vehiculos.getLast().getVehiculoId() + 1);

        vehiculos.add(vehiculo);

        log.info("END: VehiculoRepositoryConfigImpl - saveVehiculo - {}", vehiculo);
        return vehiculo;
    }

    @Override
    public Optional<Vehiculo> buscarVehiculo(Long vehiculoId) {
        return vehiculos.stream()
                .filter(e -> e.getVehiculoId().equals(vehiculoId))
                .findFirst();
    }

    @Override
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    @PostConstruct
    private void cargarVehiculosConfig() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/vehiculos.json")) {
            vehiculos = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los vehiculos");
        }
    }

    @PostConstruct
    private void cargarTiposConfig() {
        ObjectMapper mapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("static/tipos-vehiculo.json")) {
            tipos = mapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Fallo al cargar los tipos de vehiculo");
        }
    }
}
