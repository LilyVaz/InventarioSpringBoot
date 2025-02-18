package com.Inventario.repository;

import com.Inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCategoriaIdCategoria(Integer idCategoria);
    List<Producto> findByProveedorIdProveedor(Integer idProveedor);
}