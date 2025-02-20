package com.Inventario.mapper;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.entity.Empleado;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    

    EmpleadoDTO toDTO(Empleado empleado);
    Empleado toEntity(EmpleadoDTO empleadoDTO);

    List<EmpleadoDTO> toDTOList(List<Empleado> empleados);
    List<Empleado> toEntityList(List<EmpleadoDTO> empleadoDTOs);
}