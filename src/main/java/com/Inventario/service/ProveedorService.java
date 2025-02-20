package com.Inventario.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventario.dto.ProveedorDTO;
import com.Inventario.entity.Proveedor;
import com.Inventario.mapper.ProveedorMapper;
import com.Inventario.repository.ProveedorRepository;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorMapper proveedorMapper;

    public List<ProveedorDTO> listAll(){
        List<Proveedor> proveedor=proveedorRepository.findAll();
        return proveedor.stream()
                        .map(proveedorMapper::toDTO)
                        .collect(Collectors.toList());
    }

    public ProveedorDTO findById(Integer idProveedor){
        Optional<Proveedor> proveedor=proveedorRepository.findById(idProveedor);
        return proveedor.map(proveedorMapper::toDTO).orElse(null);
    }

    public ProveedorDTO save(ProveedorDTO proveedorDTO){
        Proveedor proveedor=proveedorMapper.toEntity(proveedorDTO);
        Proveedor saveProveedor=proveedorRepository.save(proveedor);
        return proveedorMapper.toDTO(saveProveedor);
    }

    public ProveedorDTO update(Integer idProveedor, ProveedorDTO proveedorDTO){
        Proveedor proveedorUpdate=proveedorRepository.findById(idProveedor)
            .orElseThrow(()-> new RuntimeException("Registro no encontrado"));

            proveedorUpdate=proveedorMapper.toEntity(proveedorDTO);
            proveedorUpdate.setIdProveedor(idProveedor);

            Proveedor proveedorSave=proveedorRepository.save(proveedorUpdate);

            return proveedorMapper.toDTO(proveedorSave);
    }

    public void delete(Integer idProveedor){
        proveedorRepository.deleteById(idProveedor);
    }
}
