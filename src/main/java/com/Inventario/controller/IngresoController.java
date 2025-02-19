package com.Inventario.controller;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping
    public List<IngresoDTO> findAll() {
        return ingresoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<IngresoDTO> findById(@PathVariable Integer id) {
        return ingresoService.findById(id);
    }

    @PostMapping
    public IngresoDTO save(@RequestBody IngresoDTO ingresoDTO) {
        return ingresoService.save(ingresoDTO);
    }

    @PutMapping("/{id}")
    public IngresoDTO update(@PathVariable Integer id, @RequestBody IngresoDTO ingresoDTO) {
        return ingresoService.update(id, ingresoDTO);
    }
}
