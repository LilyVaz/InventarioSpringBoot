package com.Inventario.dto;

import com.Inventario.entity.util.TipoContacto;
import com.Inventario.entity.util.TipoEntidad;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContactoDTO {
    private Integer idContacto;
    private Integer idEntidad;
    private TipoEntidad tipoEntidad;
    private TipoContacto tipoContacto;
    private String valor;
}
