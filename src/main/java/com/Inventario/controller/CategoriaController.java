package com.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController{
    
    @Autowired 
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> listAll(){
        return categoriaService.listAll();
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Integer idCategoria){
        CategoriaDTO categoriaDTO=categoriaService.findById(idCategoria);
        return categoriaDTO!=null? ResponseEntity.ok(categoriaDTO): ResponseEntity.notFound().build();
    }

    @PostMapping
    public CategoriaDTO create(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.save(categoriaDTO);
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<CategoriaDTO>update(@PathVariable Integer idCategoria, @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO updateCategpria=categoriaService.update(idCategoria, categoriaDTO);
        return updateCategpria!= null?ResponseEntity.ok(updateCategpria): ResponseEntity.notFound().build();
    }  

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> delete(@PathVariable Integer idCategoria){
        categoriaService.delete(idCategoria);
        return ResponseEntity.noContent().build();
    }
}