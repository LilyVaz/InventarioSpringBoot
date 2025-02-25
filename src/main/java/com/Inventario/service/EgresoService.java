package com.Inventario.service;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.entity.Egreso;
import com.Inventario.mapper.EgresoMapper;
import com.Inventario.repository.EgresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EgresoService {

    @Autowired
    private EgresoRepository egresoRepository;
    
    @Autowired
    private EgresoMapper egresoMapper;

    public List<EgresoDTO> listAll() {
        List<Egreso> egresos = egresoRepository.findAll();
        return egresos.stream()
                      .map(egresoMapper::toDTO)
                      .collect(Collectors.toList());
    }

    public EgresoDTO findById(Integer idEgreso) {
        Optional<Egreso> egreso = egresoRepository.findById(idEgreso);
        return egreso.map(egresoMapper::toDTO).orElse(null);
    }

    public EgresoDTO save(EgresoDTO egresoDTO) {
        Egreso egreso = egresoMapper.toEntity(egresoDTO);
        Egreso savedEgreso = egresoRepository.save(egreso);
        return egresoMapper.toDTO(savedEgreso);
    }

    public EgresoDTO update(Integer idEgreso, EgresoDTO egresoDTO) {
        Egreso egresoUpdate = egresoRepository.findById(idEgreso)
                .orElseThrow(() -> new RuntimeException("Egreso no encontrado"));

        egresoMapper.updateEntity(egresoDTO, egresoUpdate);
        egresoUpdate.setIdEgreso(idEgreso);

        Egreso savedEgreso = egresoRepository.save(egresoUpdate);
        return egresoMapper.toDTO(savedEgreso);
    }

    public void delete(Integer idEgreso) {
        egresoRepository.deleteById(idEgreso);
    }
}
