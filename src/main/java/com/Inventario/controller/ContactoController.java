package com.Inventario.controller;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<ContactoDTO> listAll() {
        return contactoService.listAll();
    }

    @GetMapping("/{idContacto}")
    public ResponseEntity<ContactoDTO> findById(@PathVariable Integer idContacto) {
        ContactoDTO contactoDTO = contactoService.findById(idContacto);
        return contactoDTO != null ? ResponseEntity.ok(contactoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ContactoDTO create(@RequestBody ContactoDTO contactoDTO) {
        return contactoService.save(contactoDTO);
    }

    @PutMapping("/{idContacto}")
    public ResponseEntity<ContactoDTO> update(@PathVariable Integer idContacto, @RequestBody ContactoDTO contactoDTO) {
        ContactoDTO updatedContacto = contactoService.update(idContacto, contactoDTO);
        return updatedContacto != null ? ResponseEntity.ok(updatedContacto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idContacto}")
    public ResponseEntity<Void> delete(@PathVariable Integer idContacto) {
        contactoService.delete(idContacto);
        return ResponseEntity.noContent().build();
    }
}
