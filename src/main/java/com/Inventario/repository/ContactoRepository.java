package com.Inventario.repository;

import com.Inventario.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
    List<Contacto> findByIdEntidadAndTipoEntidad(Integer idEntidad, String tipoEntidad);
}