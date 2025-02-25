package com.Inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventario.entity.HistorialInventario;
import com.Inventario.entity.Inventario;
import com.Inventario.repository.HistorialInventarioRepository;
import com.Inventario.repository.InventarioRepository;

@Service
public class ConsultasDatosService {
    
    @Autowired
    private InventarioRepository inventarioRepository;
    
    @Autowired
    private HistorialInventarioRepository historialInventarioRepository;

    public List<Inventario> findAllInventario() {
        return inventarioRepository.findAll();
    }

    public Inventario findByIdInventario(Integer id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public List<HistorialInventario> findAllHistorial() {
        return historialInventarioRepository.findAll();
    }

    public HistorialInventario findByIdHistorial(Integer id) {
        return historialInventarioRepository.findById(id).orElse(null);
    }

}
