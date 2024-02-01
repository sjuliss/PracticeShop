package com.suraShop.jss.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Embeddable
public class PedidosIdEntity {

    @Column(name="id_pedido", nullable = false)
    private int idPedido;

    @Column(name="linea", nullable = false)
    private int linea;

}
