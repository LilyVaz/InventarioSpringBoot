package com.Inventario.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.Inventario.dto.ProveedorDTO;
import com.Inventario.entity.Proveedor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {
    
    ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

    ProveedorDTO toDTO(Proveedor proveedor);
    Proveedor toEntity(ProveedorDTO proveedorDTO);

    List<ProveedorDTO> toDTOList(List<Proveedor> proveedores);
    List<Proveedor> toEntityList(List<ProveedorDTO> proveedorDTOs);
}