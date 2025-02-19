package com.Inventario.service;

import com.Inventario.dto.ProveedorDTO;
import com.Inventario.entity.Proveedor;
import com.Inventario.mapper.ProveedorMapper;
import com.Inventario.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    public List<ProveedorDTO> findAll() {
        return proveedorMapper.toDTOList(proveedorRepository.findAll());
    }

    public Optional<ProveedorDTO> findById(Integer id) {
        return proveedorRepository.findById(id).map(proveedorMapper::toDTO);
    }

    public ProveedorDTO save(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = proveedorMapper.toEntity(proveedorDTO);
        return proveedorMapper.toDTO(proveedorRepository.save(proveedor));
    }

    public ProveedorDTO update(Integer id, ProveedorDTO proveedorDTO) {
        Optional<Proveedor> proveedorExistente = proveedorRepository.findById(id);
        if (proveedorExistente.isPresent()) {
            Proveedor proveedor = proveedorMapper.toEntity(proveedorDTO);
            proveedor.setIdProveedor(id);
            return proveedorMapper.toDTO(proveedorRepository.save(proveedor));
        }
        return null; // O manejar con una excepción personalizada
    }
    
    public void deleteById(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
