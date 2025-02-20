package com.Inventario.mapper;

import com.Inventario.dto.InventarioDTO;
import com.Inventario.entity.Inventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    @Mapping(source = "producto.idProducto", target = "idProducto")
    InventarioDTO toDTO(Inventario inventario);

    @Mapping(source = "idProducto", target = "producto.idProducto")
    Inventario toEntity(InventarioDTO inventarioDTO);

    List<InventarioDTO> toDTOList(List<Inventario> inventarios);
    List<Inventario> toEntityList(List<InventarioDTO> inventarioDTOs);
}
