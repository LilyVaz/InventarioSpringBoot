package com.Inventario.mapper;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoria.idCategoria", target = "idCategoria")
    @Mapping(source = "proveedor.idProveedor", target = "idProveedor")
    ProductoDTO toDTO(Producto producto);

    @Mapping(source = "idCategoria", target = "categoria.idCategoria")
    @Mapping(source = "idProveedor", target = "proveedor.idProveedor")
    Producto toEntity(ProductoDTO productoDTO);

    List<ProductoDTO> toDTOList(List<Producto> productos);
    List<Producto> toEntityList(List<ProductoDTO> productoDTOs);
}
