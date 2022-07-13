package com.rentalocales.repositories;

import com.rentalocales.models.TipoEvento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer> {
}
