package com.Inventario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.entity.Empleado;
import com.Inventario.mapper.EmpleadoMapper;
import com.Inventario.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    public List<EmpleadoDTO> listAll(){
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream()
                        .map(empleadoMapper::toDTO)
                        .collect(Collectors.toList());
    }

    public EmpleadoDTO findById(Integer idEmpleado){
        Optional<Empleado> empleado = empleadoRepository.findById(idEmpleado);
        return empleado.map(empleadoMapper::toDTO).orElse(null);
    }

    public EmpleadoDTO save(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoMapper.toEntity(empleadoDTO);
        Empleado savedEmpleado = empleadoRepository.save(empleado);
        return empleadoMapper.toDTO(savedEmpleado);
    }

    public EmpleadoDTO update(Integer idEmpleado, EmpleadoDTO empleadoDTO){
        Empleado empleadoUpdate = empleadoRepository.findById(idEmpleado)
            .orElseThrow(() -> new RuntimeException("No se encontró el registro"));

        empleadoMapper.updateEntity(empleadoDTO, empleadoUpdate);
        empleadoUpdate.setIdEmpleado(idEmpleado);

        Empleado empleadoSaved = empleadoRepository.save(empleadoUpdate);
        return empleadoMapper.toDTO(empleadoSaved);
    }

    public void delete(Integer idEmpleado){
        empleadoRepository.deleteById(idEmpleado);
    }
}
