package com.Inventario.service;

import com.Inventario.dto.HistorialInventarioDTO;
import com.Inventario.entity.HistorialInventario;
import com.Inventario.mapper.HistorialInventarioMapper;
import com.Inventario.repository.HistorialInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialInventarioService {

    @Autowired
    private HistorialInventarioRepository historialInventarioRepository;

    @Autowired
    private HistorialInventarioMapper historialInventarioMapper;

    
    public List<HistorialInventarioDTO> findAll() {
        List<HistorialInventario> historial = historialInventarioRepository.findAll();
        return historialInventarioMapper.toDTOList(historial);
    }

    public Optional<HistorialInventarioDTO> findById(Integer id) {
        return historialInventarioRepository.findById(id).map(historialInventarioMapper::toDTO);
    }
}
