package com.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventario.service.ConsultasDatosService;
import com.Inventario.entity.HistorialInventario;
import com.Inventario.entity.Inventario;


@RestController
@RequestMapping("/api/consultasDatos")
public class ConsultasDatosController {

    @Autowired
    private ConsultasDatosService consultasDatosService;

    @GetMapping("/inventario")
    public List<Inventario> findAllInventario() {
        return consultasDatosService.findAllInventario();
    }

    @GetMapping("/inventario/{id}")
    public ResponseEntity<Inventario> findByIdInventario(@PathVariable Integer id) {
        Inventario inventario = consultasDatosService.findByIdInventario(id);
        return inventario != null ? ResponseEntity.ok(inventario) : ResponseEntity.notFound().build();
    }

    @GetMapping("/historial")
    public List<HistorialInventario> findAllHistorial() {
        return consultasDatosService.findAllHistorial();
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<HistorialInventario> findByIdHistorial(@PathVariable Integer id) {
        HistorialInventario historial = consultasDatosService.findByIdHistorial(id);
        return historial != null ? ResponseEntity.ok(historial) : ResponseEntity.notFound().build();
    }

}
