package com.Inventario.controller;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.service.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    @GetMapping
    public List<IngresoDTO> listAll() {
        return ingresoService.listAll();
    }

    @GetMapping("/{idIngreso}")
    public ResponseEntity<IngresoDTO> findById(@PathVariable Integer idIngreso) {
        IngresoDTO ingresoDTO = ingresoService.findById(idIngreso);
        return ingresoDTO != null ? ResponseEntity.ok(ingresoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public IngresoDTO create(@RequestBody IngresoDTO ingresoDTO) {
        return ingresoService.save(ingresoDTO);
    }

    @PutMapping("/{idIngreso}")
    public ResponseEntity<IngresoDTO> update(@PathVariable Integer idIngreso, @RequestBody IngresoDTO ingresoDTO) {
        IngresoDTO updatedIngreso = ingresoService.update(idIngreso, ingresoDTO);
        return updatedIngreso != null ? ResponseEntity.ok(updatedIngreso) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idIngreso}")
    public ResponseEntity<Void> delete(@PathVariable Integer idIngreso) {
        ingresoService.delete(idIngreso);
        return ResponseEntity.noContent().build();
    }
}
