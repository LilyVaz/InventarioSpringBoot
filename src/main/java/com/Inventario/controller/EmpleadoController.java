package com.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoDTO> listAll(){
        return empleadoService.listAll();
    }

    @GetMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Integer idEmpleado){
        EmpleadoDTO empleadoDTO = empleadoService.findById(idEmpleado);
        return empleadoDTO != null ? ResponseEntity.ok(empleadoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EmpleadoDTO create(@RequestBody EmpleadoDTO empleadoDTO){
        return empleadoService.save(empleadoDTO);
    }

    @PutMapping("/{idEmpleado}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Integer idEmpleado, @RequestBody EmpleadoDTO empleadoDTO){
        EmpleadoDTO updatedEmpleado = empleadoService.update(idEmpleado, empleadoDTO);
        return updatedEmpleado != null ? ResponseEntity.ok(updatedEmpleado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEmpleado}")
    public ResponseEntity<Void> delete(@PathVariable Integer idEmpleado){
        empleadoService.delete(idEmpleado);
        return ResponseEntity.noContent().build();
    }
}
