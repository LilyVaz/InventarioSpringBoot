package com.Inventario.mapper;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.entity.Contacto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactoMapper {
    

    ContactoDTO toDTO(Contacto contacto);
    Contacto toEntity(ContactoDTO contactoDTO);

    List<ContactoDTO> toDTOList(List<Contacto> contactos);
    List<Contacto> toEntityList(List<ContactoDTO> contactoDTOs);

    void updateEntity(ContactoDTO contactoDTO, @MappingTarget Contacto contacto);
}
