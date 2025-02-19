package com.Inventario.controller;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaDTO> findById(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public CategoriaDTO save(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.save(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.update(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        categoriaService.deleteById(id);
    }
}
