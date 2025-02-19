package com.Inventario.controller;

import com.Inventario.dto.ContactoDTO;
import com.Inventario.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<ContactoDTO> findAll() {
        return contactoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ContactoDTO> findById(@PathVariable Integer id) {
        return contactoService.findById(id);
    }

    @PostMapping
    public ContactoDTO save(@RequestBody ContactoDTO contactoDTO) {
        return contactoService.save(contactoDTO);
    }

    @PutMapping("/{id}")
    public ContactoDTO update(@PathVariable Integer id, @RequestBody ContactoDTO contactoDTO) {
        return contactoService.update(id, contactoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        contactoService.deleteById(id);
    }
}
