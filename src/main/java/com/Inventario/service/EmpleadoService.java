package com.Inventario.service;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.entity.Empleado;
import com.Inventario.mapper.EmpleadoMapper;
import com.Inventario.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    public List<EmpleadoDTO> findAll() {
        return empleadoMapper.toDTOList(empleadoRepository.findAll());
    }

    public Optional<EmpleadoDTO> findById(Integer id) {
        return empleadoRepository.findById(id).map(empleadoMapper::toDTO);
    }

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        return empleadoMapper.toDTO(empleadoRepository.save(empleado));
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
