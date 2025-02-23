package com.munidigital.carwash.repository.jpa;

import com.munidigital.carwash.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepositoryJpa extends JpaRepository<Vehiculo, Long> {
}
