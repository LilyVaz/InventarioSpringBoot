package com.Inventario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial_inventario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistorialInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorial;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "fk_historial_producto"))
    private Producto producto;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private LocalDate fechaRegistro;
}
