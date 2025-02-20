package com.Inventario.controller;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listAll() {
        return productoService.listAll();
    }

    @GetMapping("/{idProducto}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Integer idProducto) {
        ProductoDTO productoDTO = productoService.findById(idProducto);
        return productoDTO != null ? ResponseEntity.ok(productoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProductoDTO create(@RequestBody ProductoDTO productoDTO) {
        return productoService.save(productoDTO);
    }

    @PutMapping("/{idProducto}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Integer idProducto, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoActualizado = productoService.update(idProducto, productoDTO);
        return productoActualizado != null ? ResponseEntity.ok(productoActualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idProducto}")
    public ResponseEntity<Void> delete(@PathVariable Integer idProducto) {
        productoService.delete(idProducto);
        return ResponseEntity.noContent().build();
    }
}
