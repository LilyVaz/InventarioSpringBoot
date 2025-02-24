package com.Inventario.service;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.entity.Contacto;
import com.Inventario.mapper.ContactoMapper;
import com.Inventario.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private ContactoMapper contactoMapper;

    public List<ContactoDTO> listAll() {
        List<Contacto> contactos = contactoRepository.findAll();
        return contactos.stream()
                .map(contactoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContactoDTO findById(Integer idContacto) {
        Optional<Contacto> contacto = contactoRepository.findById(idContacto);
        return contacto.map(contactoMapper::toDTO).orElse(null);
    }

    public ContactoDTO save(ContactoDTO contactoDTO) {
        Contacto contacto = contactoMapper.toEntity(contactoDTO);
        Contacto savedContacto = contactoRepository.save(contacto);
        return contactoMapper.toDTO(savedContacto);
    }

    public ContactoDTO update(Integer idContacto, ContactoDTO contactoDTO) {
        Contacto contactoUpdate = contactoRepository.findById(idContacto)
                .orElseThrow(() -> new RuntimeException("No se encontró el registro"));

        contactoMapper.updateEntity(contactoDTO, contactoUpdate);
        contactoUpdate.setIdContacto(idContacto);

        Contacto contactoSaved = contactoRepository.save(contactoUpdate);
        return contactoMapper.toDTO(contactoSaved);
    }

    public void delete(Integer idContacto) {
        contactoRepository.deleteById(idContacto);
    }
}
