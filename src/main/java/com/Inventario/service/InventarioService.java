package com.Inventario.service;

import com.Inventario.dto.InventarioDTO;
import com.Inventario.mapper.InventarioMapper;
import com.Inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private InventarioMapper inventarioMapper;

    public List<InventarioDTO> findAll() {
        return inventarioMapper.toDTOList(inventarioRepository.findAll());
    }
}
