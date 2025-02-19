package com.Inventario.service;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.entity.Producto;
import com.Inventario.mapper.ProductoMapper;
import com.Inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDTO> findAll() {
        return productoMapper.toDTOList(productoRepository.findAll());
    }

    public Optional<ProductoDTO> findById(Integer id) {
        return productoRepository.findById(id).map(productoMapper::toDTO);
    }

    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        return productoMapper.toDTO(productoRepository.save(producto));
    }

    public ProductoDTO update(Integer id, ProductoDTO productoDTO) {
        Optional<Producto> productoExistente = productoRepository.findById(id);
        if (productoExistente.isPresent()) {
            Producto producto = productoMapper.toEntity(productoDTO);
            producto.setIdProducto(id);
            return productoMapper.toDTO(productoRepository.save(producto));
        }
        return null;
    }
    
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}
