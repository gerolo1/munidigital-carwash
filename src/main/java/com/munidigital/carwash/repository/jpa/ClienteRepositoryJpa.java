package com.munidigital.carwash.repository.jpa;

import com.munidigital.carwash.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {
}
