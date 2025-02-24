package com.Inventario.entity;


import com.Inventario.entity.util.TipoContacto;
import com.Inventario.entity.util.TipoEntidad;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Data
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContacto;

    @Column(nullable = false)
    private Integer idEntidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEntidad tipoEntidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoContacto tipoContacto;

    @Column(nullable = false, length = 100)
    private String valor;
}

