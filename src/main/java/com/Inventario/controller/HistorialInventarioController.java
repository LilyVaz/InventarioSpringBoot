package com.Inventario.controller;

import com.Inventario.dto.HistorialInventarioDTO;
import com.Inventario.service.HistorialInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial-Inventario")
public class HistorialInventarioController {

    @Autowired
    private HistorialInventarioService historialInventarioService;

    @GetMapping
    public List<HistorialInventarioDTO> findAll() {
        return historialInventarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<HistorialInventarioDTO> findById(@PathVariable Integer id) {
        return historialInventarioService.findById(id);
    }
}
