package com.Inventario.controller;

import com.Inventario.dto.ProveedorDTO;
import com.Inventario.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorDTO> findAll() {
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProveedorDTO> findById(@PathVariable Integer id) {
        return proveedorService.findById(id);
    }

    @PostMapping
    public ProveedorDTO save(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.save(proveedorDTO);
    }

    @PutMapping("/{id}")
    public ProveedorDTO update(@PathVariable Integer id, @RequestBody ProveedorDTO proveedorDTO) {
        return proveedorService.update(id, proveedorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        proveedorService.deleteById(id);
    }
}
