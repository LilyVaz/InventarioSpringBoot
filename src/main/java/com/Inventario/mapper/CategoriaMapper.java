package com.Inventario.mapper;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toDTOList(List<Categoria> categorias);
    List<Categoria> toEntityList(List<CategoriaDTO> categoriaDTOs);
}
