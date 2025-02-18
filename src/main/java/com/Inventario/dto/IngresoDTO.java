package com.Inventario.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class IngresoDTO {
    private Integer idIngreso;
    private Integer idProducto;
    private String descripcion;
    private Integer cantidad;
    private BigDecimal monto;
    private LocalDateTime fechaIngreso;
    private Integer idEmpleado;
}
