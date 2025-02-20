package com.Inventario.mapper;

import com.Inventario.dto.IngresoDTO;
import com.Inventario.entity.Ingreso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
}
