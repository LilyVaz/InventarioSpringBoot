package com.Inventario.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpleadoDTO {
    private Integer idEmpleado;
    private String nombre;
    private String puesto;
    private LocalDate fechaContratacion;
    private Boolean estado;
}