package com.Inventario.controller;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/egresos")
public class EgresoController {

    @Autowired
    private EgresoService egresoService;

    @GetMapping
    public List<EgresoDTO> findAll() {
        return egresoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EgresoDTO> findById(@PathVariable Integer id) {
        return egresoService.findById(id);
    }

    @PostMapping
    public EgresoDTO save(@RequestBody EgresoDTO egresoDTO) {
        return egresoService.save(egresoDTO);
    }

    @PutMapping("/{id}")
    public EgresoDTO update(@PathVariable Integer id, @RequestBody EgresoDTO egresoDTO) {
        return egresoService.update(id, egresoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        egresoService.deleteById(id);
    }
}
