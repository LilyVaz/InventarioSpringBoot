package com.Inventario.mapper;

import com.Inventario.dto.HistorialInventarioDTO;
import com.Inventario.entity.HistorialInventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HistorialInventarioMapper {

    HistorialInventarioMapper INSTANCE = Mappers.getMapper(HistorialInventarioMapper.class);

    @Mapping(source = "producto.idProducto", target = "idProducto")
    HistorialInventarioDTO toDTO(HistorialInventario historialInventario);

    @Mapping(source = "idProducto", target = "producto.idProducto")
    HistorialInventario toEntity(HistorialInventarioDTO historialInventarioDTO);

    List<HistorialInventarioDTO> toDTOList(List<HistorialInventario> historialInventarioList);
    List<HistorialInventario> toEntityList(List<HistorialInventarioDTO> historialInventarioDTOList);
}
