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

import com.Inventario.dto.ProveedorDTO;
import com.Inventario.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<ProveedorDTO>listAll(){
        return proveedorService.listAll();
    }

    @GetMapping("/{idProveedor}")
    public ResponseEntity<ProveedorDTO>findById(@PathVariable Integer idProveedor){
        ProveedorDTO proveedorDTO= proveedorService.findById(idProveedor);
        return proveedorDTO!=null? ResponseEntity.ok(proveedorDTO):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProveedorDTO create(@RequestBody ProveedorDTO proveedorDTO){
        return proveedorService.save(proveedorDTO);
    }

    @PutMapping("/{idProveedor}")
    public ResponseEntity<ProveedorDTO> update(@PathVariable Integer idProveedor, @RequestBody ProveedorDTO porProveedorDTO){
        ProveedorDTO updateProveedor= proveedorService.update(idProveedor, porProveedorDTO);
        return updateProveedor!=null? ResponseEntity.ok(updateProveedor): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<Void> delete(@PathVariable Integer idProveedor){
        proveedorService.delete(idProveedor);
        return ResponseEntity.noContent().build();
    }

}
