package com.Inventario.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

enum TipoEntidad {
    PROVEEDOR, EMPLEADO
}

enum TipoContacto {
    TELEFONO, EMAIL
}
