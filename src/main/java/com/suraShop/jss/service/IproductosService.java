package com.suraShop.jss.service;

import com.suraShop.jss.dto.ProductosDto;
import java.util.List;

public interface IproductosService {
    ProductosDto crearProducto(ProductosDto productoDto);
    ProductosDto actualizaProducto(ProductosDto productoDto);
    String eliminarProducto(ProductosDto productoDto);

    ProductosDto buscarProductoId(Integer idProducto);

    List<ProductosDto> buscarTodosProductos();

    List<ProductosDto> findAllByFechaProd(String date1, String date2);

}
