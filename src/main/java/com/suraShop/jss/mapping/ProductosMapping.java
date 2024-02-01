package com.suraShop.jss.mapping;

import com.suraShop.jss.Entity.ProductosEntity;
import com.suraShop.jss.dto.ProductosDto;
import com.suraShop.jss.util.LocalDateFomatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductosMapping {

    public ProductosEntity ProductosDtoToProductosEntity(ProductosDto productosDto){
        return ProductosEntity.builder()
                .idProducto(productosDto.getIdProducto())
                .descripcionProd(productosDto.getDescripcionProd())
                .fechaProd(new LocalDateFomatter().dateStringtoLocalDate(productosDto.getFechaProd()))
                .precio(productosDto.getPrecio())
                .unidades(productosDto.getUnidades())
                .build();

    }

    public ProductosDto ProductosEntityToProductosDto(Optional<ProductosEntity> productosEntity){
        return ProductosDto.builder()
                .idProducto(productosEntity.get().getIdProducto())
                .descripcionProd(productosEntity.get().getDescripcionProd())
                .fechaProd(new LocalDateFomatter().LocalDateToStringDate(productosEntity.get().getFechaProd()))
                .precio(productosEntity.get().getPrecio())
                .unidades(productosEntity.get().getUnidades())
                .build();

    }

    public List<ProductosDto> listProductosEntityTolistProductosDto(List<ProductosEntity> entities){
        List<ProductosDto> productosDtos = new ArrayList<>();
        entities.forEach(productosEntity -> {
            ProductosDto productosDTO = ProductosEntityToProductosDto(Optional.ofNullable(productosEntity));
            productosDtos.add(productosDTO);
        });
        return productosDtos;
    }

}
