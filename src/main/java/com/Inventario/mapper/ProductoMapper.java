package com.Inventario.mapper;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.entity.Categoria;
import com.Inventario.entity.Producto;
import com.Inventario.entity.Proveedor;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoria.idCategoria", target = "idCategoria")
    @Mapping(source = "proveedor.idProveedor", target = "idProveedor")
    ProductoDTO toDTO(Producto producto);

    @Mapping(source = "idCategoria", target = "categoria", qualifiedByName = "mapCategoria")
    @Mapping(source = "idProveedor", target = "proveedor", qualifiedByName = "mapProveedor")
    Producto toEntity(ProductoDTO productoDTO);

    List<ProductoDTO> toDTOList(List<Producto> productos);
    List<Producto> toEntityList(List<ProductoDTO> productosDTO);

    @Mapping(target = "idProducto", ignore = true) // Evita modificar el ID en actualizaciones
    @Mapping(source = "idCategoria", target = "categoria", qualifiedByName = "mapCategoria")
    @Mapping(source = "idProveedor", target = "proveedor", qualifiedByName = "mapProveedor")
    void updateEntity(ProductoDTO productoDTO, @MappingTarget Producto producto);

    // Métodos para mapear IDs a objetos completos
    @Named("mapCategoria")
    default Categoria mapCategoria(Integer idCategoria) {
        if (idCategoria == null) return null;
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        return categoria;
    }

    @Named("mapProveedor")
    default Proveedor mapProveedor(Integer idProveedor) {
        if (idProveedor == null) return null;
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(idProveedor);
        return proveedor;
    }
}
 