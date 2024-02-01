package com.suraShop.jss.service;

import com.suraShop.jss.dto.PedidosDto;
import java.util.List;

public interface IpedidosService {

    PedidosDto crearPedido(PedidosDto pedidosDto);

    String  eliminarPedido(PedidosDto pedidosDto);

    List<PedidosDto> findAllByfechaPedido(String date1, String date2);

}
