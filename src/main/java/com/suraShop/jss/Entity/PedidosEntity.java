package com.suraShop.jss.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name="pedidos")
public class PedidosEntity {

    @EmbeddedId
    private PedidosIdEntity pedidosId;

    @Column(name="fecha_pedido")
    private LocalDate fechaPedido;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity idUsuario;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductosEntity idProducto;

    @Column(name = "unidades")
    private int unidades;

    @Column(name = "valor")
    private Long valor;

}
