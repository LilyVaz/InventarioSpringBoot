package com.Inventario.controller;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoDTO> findAll() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EmpleadoDTO> findById(@PathVariable Integer id) {
        return empleadoService.findById(id);
    }

    @PostMapping
    public EmpleadoDTO save(@RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.save(empleadoDTO);
    }

    @PutMapping("/{id}")
    public EmpleadoDTO update(@PathVariable Integer id, @RequestBody EmpleadoDTO empleadoDTO) {
        return empleadoService.update(id, empleadoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        empleadoService.deleteById(id);
    }
}
