package com.suraShop.jss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductosDto {

    @JsonProperty("id_producto")
    private int idProducto;

    @JsonProperty("descripcion_prod")
    private String descripcionProd;

    @JsonProperty("fecha_prod")
    private String fechaProd;

    @JsonProperty("precio")
    private Long precio;

    @JsonProperty("unidades")
    private int unidades;
}
