package com.Inventario.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HistorialInventarioDTO {
    private Integer idHistorial;
    private Integer idProducto;
    private Integer stock;
    private LocalDate fechaRegistro;
}