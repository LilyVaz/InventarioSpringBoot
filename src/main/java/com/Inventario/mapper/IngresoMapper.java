package com.Inventario.mapper;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.entity.Empleado;
import com.Inventario.entity.Ingreso;
import com.Inventario.entity.Producto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngresoMapper {

    @Mapping(source = "producto.idProducto", target = "idProducto")
    @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
    IngresoDTO toDTO(Ingreso ingreso);

    @Mapping(source = "idProducto", target = "producto.idProducto")
    @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
    Ingreso toEntity(IngresoDTO ingresoDTO);

    List<IngresoDTO> toDTOList(List<Ingreso> ingresos);
    List<Ingreso> toEntityList(List<IngresoDTO> ingresoDTOs);

    @Mapping(target = "producto", source = "idProducto", qualifiedByName = "mapProducto")
@Mapping(target = "empleado", source = "idEmpleado", qualifiedByName = "mapEmpleado")
void updateEntity(IngresoDTO ingresoDTO, @MappingTarget Ingreso ingreso);

@Named("mapProducto")
default Producto mapProducto(Integer id) {
    if (id == null) return null;
    Producto producto = new Producto();
    producto.setIdProducto(id);
    return producto;
}

@Named("mapEmpleado")
default Empleado mapEmpleado(Integer id) {
    if (id == null) return null;
    Empleado empleado = new Empleado();
    empleado.setIdEmpleado(id);
    return empleado;
}
}
