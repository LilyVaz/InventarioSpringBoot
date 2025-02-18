package com.Inventario.repository;

import com.Inventario.entity.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EgresoRepository extends JpaRepository<Egreso, Integer> {
    List<Egreso> findByProductoIdProducto(Integer idProducto);
}
