package com.suraShop.jss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidosIdDto {

    @JsonProperty("id_pedido")
    private int idPedido;

    @JsonProperty("linea")
    private int linea;
}
