package com.munidigital.carwash.repository;

import com.munidigital.carwash.model.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
