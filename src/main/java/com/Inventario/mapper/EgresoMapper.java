package com.Inventario.mapper;

import com.Inventario.dto.EgresoDTO;
import com.Inventario.entity.Egreso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EgresoMapper {


    @Mapping(source = "producto.idProducto", target = "idProducto")
    @Mapping(source = "empleado.idEmpleado", target = "idEmpleado")
    EgresoDTO toDTO(Egreso egreso);

    @Mapping(source = "idProducto", target = "producto.idProducto")
    @Mapping(source = "idEmpleado", target = "empleado.idEmpleado")
    Egreso toEntity(EgresoDTO egresoDTO);

    List<EgresoDTO> toDTOList(List<Egreso> egresos);
    List<Egreso> toEntityList(List<EgresoDTO> egresoDTOs);
}
