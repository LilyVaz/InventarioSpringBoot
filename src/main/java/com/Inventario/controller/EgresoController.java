package com.Inventario.controller;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.service.EgresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/egresos")
public class EgresoController {

    @Autowired
    private EgresoService egresoService;

    @GetMapping
    public List<EgresoDTO> listAll() {
        return egresoService.listAll();
    }

    @GetMapping("/{idEgreso}")
    public ResponseEntity<EgresoDTO> findById(@PathVariable Integer idEgreso) {
        EgresoDTO egresoDTO = egresoService.findById(idEgreso);
        return egresoDTO != null ? ResponseEntity.ok(egresoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public EgresoDTO create(@RequestBody EgresoDTO egresoDTO) {
        return egresoService.save(egresoDTO);
    }

    @PutMapping("/{idEgreso}")
    public ResponseEntity<EgresoDTO> update(@PathVariable Integer idEgreso, @RequestBody EgresoDTO egresoDTO) {
        EgresoDTO updatedEgreso = egresoService.update(idEgreso, egresoDTO);
        return updatedEgreso != null ? ResponseEntity.ok(updatedEgreso) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEgreso}")
    public ResponseEntity<Void> delete(@PathVariable Integer idEgreso) {
        egresoService.delete(idEgreso);
        return ResponseEntity.noContent().build();
    }
}
