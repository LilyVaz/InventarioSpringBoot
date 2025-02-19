package com.Inventario.service;

import com.Inventario.dto.CategoriaDTO;
import com.Inventario.entity.Categoria;
import com.Inventario.mapper.CategoriaMapper;
import com.Inventario.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> findAll() {
        return categoriaMapper.toDTOList(categoriaRepository.findAll());
    }

    public Optional<CategoriaDTO> findById(Integer id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toDTO);
    }

    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    public CategoriaDTO update(Integer id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
            categoria.setIdCategoria(id);
            return categoriaMapper.toDTO(categoriaRepository.save(categoria));
        }
        return null;
    }
    
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
