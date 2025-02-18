package com.Inventario.mapper;

import com.Inventario.dto.EmpleadoDTO;
import com.Inventario.entity.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    
    EmpleadoMapper INSTANCE = Mappers.getMapper(EmpleadoMapper.class);

    EmpleadoDTO toDTO(Empleado empleado);
    Empleado toEntity(EmpleadoDTO empleadoDTO);

    List<EmpleadoDTO> toDTOList(List<Empleado> empleados);
    List<Empleado> toEntityList(List<EmpleadoDTO> empleadoDTOs);
}