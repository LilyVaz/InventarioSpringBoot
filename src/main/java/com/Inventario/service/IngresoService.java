package com.Inventario.service;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.entity.Ingreso;
import com.Inventario.mapper.IngresoMapper;
import com.Inventario.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private IngresoMapper ingresoMapper;

    public List<IngresoDTO> findAll() {
        return ingresoMapper.toDTOList(ingresoRepository.findAll());
    }

    public Optional<IngresoDTO> findById(Integer id) {
        return ingresoRepository.findById(id).map(ingresoMapper::toDTO);
    }

    public IngresoDTO save(IngresoDTO ingresoDTO) {
        Ingreso ingreso = ingresoMapper.toEntity(ingresoDTO);
        return ingresoMapper.toDTO(ingresoRepository.save(ingreso));
    }

    public IngresoDTO update(Integer id, IngresoDTO ingresoDTO) {
        Optional<Ingreso> ingresoExistente = ingresoRepository.findById(id);
        if (ingresoExistente.isPresent()) {
            Ingreso ingreso = ingresoMapper.toEntity(ingresoDTO);
            ingreso.setIdIngreso(id);
            return ingresoMapper.toDTO(ingresoRepository.save(ingreso));
        }
        return null;
    }
    
    public void deleteById(Integer id) {
        ingresoRepository.deleteById(id);
    }
}
