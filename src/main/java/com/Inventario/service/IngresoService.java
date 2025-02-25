package com.Inventario.service;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.entity.Ingreso;
import com.Inventario.mapper.IngresoMapper;
import com.Inventario.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private IngresoMapper ingresoMapper;

    public List<IngresoDTO> listAll() {
        List<Ingreso> ingresos = ingresoRepository.findAll();
        return ingresos.stream()
                .map(ingresoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public IngresoDTO findById(Integer idIngreso) {
        Optional<Ingreso> ingreso = ingresoRepository.findById(idIngreso);
        return ingreso.map(ingresoMapper::toDTO).orElse(null);
    }

    public IngresoDTO save(IngresoDTO ingresoDTO) {
        Ingreso ingreso = ingresoMapper.toEntity(ingresoDTO);
        Ingreso savedIngreso = ingresoRepository.save(ingreso);
        return ingresoMapper.toDTO(savedIngreso);
    }

    public IngresoDTO update(Integer idIngreso, IngresoDTO ingresoDTO) {
        Ingreso ingresoUpdate = ingresoRepository.findById(idIngreso)
                .orElseThrow(() -> new RuntimeException("No se encontró el ingreso"));

        ingresoMapper.updateEntity(ingresoDTO, ingresoUpdate);
        ingresoUpdate.setIdIngreso(idIngreso);

        Ingreso savedIngreso = ingresoRepository.save(ingresoUpdate);
        return ingresoMapper.toDTO(savedIngreso);
    }

    public void delete(Integer idIngreso) {
        ingresoRepository.deleteById(idIngreso);
    }
}
