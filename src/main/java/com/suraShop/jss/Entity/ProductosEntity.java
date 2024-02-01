package com.suraShop.jss.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name="productos")
public class ProductosEntity {

    @Id
    @Column(name = "id_producto", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "descripcion_prod")
    private String descripcionProd;

    @Column(name="fecha_prod")
    private LocalDate fechaProd;

    @Column(name="precio")
    private Long precio;

    @Column(name="unidades")
    private int unidades;
}
