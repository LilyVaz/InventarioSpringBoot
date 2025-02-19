package com.Inventario.controller;

import com.Inventario.dto.InventarioDTO;
import com.Inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Inventario")
public class InventarioController {

    @Autowired
    private InventarioService InventarioService;

    @GetMapping
    public List<InventarioDTO> findAll() {
        return InventarioService.findAll();
    }


}
