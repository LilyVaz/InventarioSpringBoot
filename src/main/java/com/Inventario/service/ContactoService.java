package com.Inventario.service;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.entity.Contacto;
import com.Inventario.mapper.ContactoMapper;
import com.Inventario.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    @Autowired
    private ContactoMapper contactoMapper;

    public List<ContactoDTO> findAll() {
        return contactoMapper.toDTOList(contactoRepository.findAll());
    }

    public Optional<ContactoDTO> findById(Integer id) {
        return contactoRepository.findById(id).map(contactoMapper::toDTO);
    }

    public ContactoDTO save(ContactoDTO contactoDTO) {
        Contacto contacto = contactoMapper.toEntity(contactoDTO);
        return contactoMapper.toDTO(contactoRepository.save(contacto));
    }

    public ContactoDTO update(Integer id, ContactoDTO contactoDTO) {
        Optional<Contacto> contactoExistente = contactoRepository.findById(id);
        if (contactoExistente.isPresent()) {
            Contacto contacto = contactoMapper.toEntity(contactoDTO);
            contacto.setIdContacto(id);
            return contactoMapper.toDTO(contactoRepository.save(contacto));
        }
        return null;
    }
    
    public void deleteById(Integer id) {
        contactoRepository.deleteById(id);
    }
}
