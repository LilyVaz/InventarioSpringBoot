package com.Inventario.service;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.entity.Egreso;
import com.Inventario.entity.Empleado;
import com.Inventario.mapper.EgresoMapper;
import com.Inventario.mapper.EmpleadoMapper;
import com.Inventario.repository.EgresoRepository;
import com.Inventario.repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EgresoService {

    @Autowired
    private EgresoRepository egresoRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private EgresoMapper egresoMapper;
    @Autowired
    private EmpleadoMapper empleadoMapper;

    public List<EgresoDTO> findAll() {
        return egresoMapper.toDTOList(egresoRepository.findAll());
    }

    public Optional<EgresoDTO> findById(Integer id) {
        return egresoRepository.findById(id).map(egresoMapper::toDTO);
    }
    
    public EgresoDTO save(EgresoDTO egresoDTO) {
        Egreso egreso = egresoMapper.toEntity(egresoDTO);
        return egresoMapper.toDTO(egresoRepository.save(egreso));
    }
    
    public EmpleadoDTO update(Integer id, EmpleadoDTO empleadoDTO) {
    Optional<Empleado> empleadoExistente = empleadoRepository.findById(id);
    if (empleadoExistente.isPresent()) {
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        empleado.setIdEmpleado(id);
        return empleadoMapper.toDTO(empleadoRepository.save(empleado));
    }
    return null;
    }

    public void deleteById(Integer id) {
        empleadoRepository.deleteById(id);
    }

}
