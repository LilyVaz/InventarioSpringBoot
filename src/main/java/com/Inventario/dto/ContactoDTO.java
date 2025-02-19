package com.Inventario.dto;

import lombok.Getter;
import lombok.Setter;
import com.Inventario.entity.TipoEntidad;
import com.Inventario.entity.TipoContacto;

@Getter
@Setter
public class ContactoDTO {
    private Integer idContacto;
    private Integer idEntidad;
    private TipoEntidad tipoEntidad;
    private TipoContacto tipoContacto;
    private String valor;
}
