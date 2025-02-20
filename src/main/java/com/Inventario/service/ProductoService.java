package com.Inventario.service;

import com.Inventario.dto.ProductoDTO;
import com.Inventario.entity.Producto;
import com.Inventario.mapper.ProductoMapper;
import com.Inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDTO> listAll() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO findById(Integer idProducto) {
        Optional<Producto> producto = productoRepository.findById(idProducto);
        return producto.map(productoMapper::toDTO).orElse(null);
    }

    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto productoGuardado = productoRepository.save(producto);
        return productoMapper.toDTO(productoGuardado);
    }

    public ProductoDTO update(Integer idProducto, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoMapper.updateEntity(productoDTO, productoExistente);
        productoExistente.setIdProducto(idProducto);

        Producto productoActualizado = productoRepository.save(productoExistente);
        return productoMapper.toDTO(productoActualizado);
    }

    public void delete(Integer idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
