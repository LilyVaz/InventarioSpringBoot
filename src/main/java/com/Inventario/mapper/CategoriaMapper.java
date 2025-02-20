package com.Inventario.mapper;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.entity.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {


    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> toDTOList(List<Categoria> categorias);
    List<Categoria> toEntityList(List<CategoriaDTO> categoriaDTOs);
}
