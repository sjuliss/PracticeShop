package com.suraShop.jss.mapping;

import com.suraShop.jss.Entity.PedidosEntity;
import com.suraShop.jss.Entity.PedidosIdEntity;
import com.suraShop.jss.dto.PedidosDto;
import com.suraShop.jss.dto.PedidosIdDto;
import com.suraShop.jss.util.LocalDateFomatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidosMapping {

    public PedidosEntity PedidosDtoToPedidosEntity(PedidosDto pedidosDto){
        return PedidosEntity.builder()
                .pedidosId(PedidosIdDtoToPedidosIdEntity(pedidosDto.getIdPedido()))
                .valor(pedidosDto.getValor())
                .idUsuario(new UsuarioMapping().UsuarioDtoToUsuarioEntity(pedidosDto.getIdUsuario()))
                .idProducto(new ProductosMapping().ProductosDtoToProductosEntity(pedidosDto.getIdProducto()))
                .unidades(pedidosDto.getUnidades())
                .fechaPedido(new LocalDateFomatter().dateStringtoLocalDate(pedidosDto.getFechaPedido()))
                .build();
    }

    public PedidosDto PedidosEntityToPedidosDto(PedidosEntity pedidosEntity){
        return PedidosDto.builder()
                .idPedido(PedidosIdEntityToPedidosIdDto(pedidosEntity.getPedidosId()))
                .valor(pedidosEntity.getValor())
                .idUsuario(new UsuarioMapping().UsuarioEntityToUsuarioDto(pedidosEntity.getIdUsuario()))
                .idProducto(new ProductosMapping().ProductosEntityToProductosDto(Optional.ofNullable(pedidosEntity.getIdProducto())))
                .unidades(pedidosEntity.getUnidades())
                .fechaPedido(new LocalDateFomatter().LocalDateToStringDate(pedidosEntity.getFechaPedido()))
                .build();
    }


    public PedidosIdEntity PedidosIdDtoToPedidosIdEntity(PedidosIdDto pedidosIdDto){
        return PedidosIdEntity.builder()
                .idPedido(pedidosIdDto.getIdPedido())
                .linea(pedidosIdDto.getLinea())
                .build();
    }

    public PedidosIdDto PedidosIdEntityToPedidosIdDto(PedidosIdEntity pedidosIdEntity){
        return PedidosIdDto.builder()
                .idPedido(pedidosIdEntity.getIdPedido())
                .linea(pedidosIdEntity.getLinea())
                .build();
    }

    public List<PedidosDto> listPedidosEntityTolistPedidosDto(List<PedidosEntity> entities){
        List<PedidosDto> pedidosDtos = new ArrayList<>();
        entities.forEach(pedidosEntity -> {
            PedidosDto pedidosDTO = PedidosEntityToPedidosDto(pedidosEntity);
            pedidosDtos.add(pedidosDTO);
        });
        return pedidosDtos;
    }
}
