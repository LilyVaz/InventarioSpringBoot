package com.Inventario.mapper;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.entity.Egreso;
import com.Inventario.entity.Empleado;
import com.Inventario.entity.Producto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EgresoMapper {


    @Mapping(source = "producto.idProducto", target = "producto")
    @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
    EgresoDTO toDTO(Egreso egreso);

    @Mapping(source = "producto", target = "producto.idProducto")
    @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
    Egreso toEntity(EgresoDTO egresoDTO);

    List<EgresoDTO> toDTOList(List<Egreso> egresos);
    List<Egreso> toEntityList(List<EgresoDTO> egresoDTOs);

    
  @Mapping(target = "producto", source = "producto", qualifiedByName = "mapProducto")
@Mapping(target = "empleado", source = "idEmpleado", qualifiedByName = "mapEmpleado")
void updateEntity(EgresoDTO egresoDTO, @MappingTarget Egreso egreso);

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
