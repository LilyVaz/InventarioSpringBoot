package com.Inventario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(nullable = false, length = 100)
    private String nombre;
}
