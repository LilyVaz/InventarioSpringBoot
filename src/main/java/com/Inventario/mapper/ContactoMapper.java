package com.Inventario.mapper;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.entity.Contacto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactoMapper {
    
    ContactoMapper INSTANCE = Mappers.getMapper(ContactoMapper.class);

    ContactoDTO toDTO(Contacto contacto);
    Contacto toEntity(ContactoDTO contactoDTO);

    List<ContactoDTO> toDTOList(List<Contacto> contactos);
    List<Contacto> toEntityList(List<ContactoDTO> contactoDTOs);
}
