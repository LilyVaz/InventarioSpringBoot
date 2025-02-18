package com.Inventario.repository;

import com.Inventario.entity.HistorialInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistorialInventarioRepository extends JpaRepository<HistorialInventario, Integer> {
    List<HistorialInventario> findByFechaRegistro(LocalDate fechaRegistro);
}