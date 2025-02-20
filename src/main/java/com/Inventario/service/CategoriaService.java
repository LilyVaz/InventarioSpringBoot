package com.Inventario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.entity.Categoria;
import com.Inventario.mapper.CategoriaMapper;
import com.Inventario.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> listAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                        .map(categoriaMapper::toDTO )
                        .collect(Collectors.toList());
    }

    public CategoriaDTO findById(Integer idCategoria){
        Optional <Categoria> categoria=categoriaRepository.findById(idCategoria);
        return categoria.map(categoriaMapper::toDTO).orElse(null);
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO){
        Categoria categoria= categoriaMapper.toEntity(categoriaDTO);
        Categoria saveCategoria= categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(saveCategoria);
    }


    public CategoriaDTO update(Integer idCategoria, CategoriaDTO CategoriaDTO){
        Categoria categoriaUpdate=categoriaRepository.findById(idCategoria)
            .orElseThrow(()-> new RuntimeException("No se encontro el registro"));

            categoriaUpdate=categoriaMapper.toEntity(CategoriaDTO);
            categoriaUpdate.setIdCategoria(idCategoria);

            Categoria categoriaSave=categoriaRepository.save(categoriaUpdate);

            return categoriaMapper.toDTO(categoriaSave);
    }

    public void delete(Integer idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }

}
