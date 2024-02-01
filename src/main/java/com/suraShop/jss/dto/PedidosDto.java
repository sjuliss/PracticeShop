package com.suraShop.jss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDto {

    @JsonProperty("id_pedido")
    private PedidosIdDto idPedido;

    @JsonProperty("fecha_pedido")
    private String fechaPedido;

    @JsonProperty("id_usuario")
    private UsuarioDto idUsuario;

    @JsonProperty("id_producto")
    private ProductosDto idProducto;

    @JsonProperty("unidades")
    private int unidades;

    @JsonProperty("valor")
    private Long valor;
}
