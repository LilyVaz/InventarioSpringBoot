package com.Inventario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {
    @Id
    @Column(name = "id_producto")
    private Integer idProducto;

    @OneToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;
}
