package com.Inventario.controller;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> findAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductoDTO> findById(@PathVariable Integer id) {
        return productoService.findById(id);
    }

    @PostMapping
    public ProductoDTO save(@RequestBody ProductoDTO productoDTO) {
        return productoService.save(productoDTO);
    }

    @PutMapping("/{id}")
    public ProductoDTO update(@PathVariable Integer id, @RequestBody ProductoDTO productoDTO) {
        return productoService.update(id, productoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        productoService.deleteById(id);
    }
}
