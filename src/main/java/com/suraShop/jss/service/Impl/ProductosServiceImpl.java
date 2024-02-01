package com.suraShop.jss.service.Impl;

import com.suraShop.jss.Entity.ProductosEntity;
import com.suraShop.jss.dto.ProductosDto;
import com.suraShop.jss.mapping.ProductosMapping;
import com.suraShop.jss.repository.IproductosRepo;
import com.suraShop.jss.service.IproductosService;
import com.suraShop.jss.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductosServiceImpl implements IproductosService {

    private final IproductosRepo iproductosRepo;

    @Override
    public ProductosDto crearProducto(ProductosDto productoDto) {

        Optional<ProductosEntity> productoExiste = iproductosRepo.findById(productoDto.getIdProducto());

        if (Objects.nonNull(productoExiste)){
            ProductosEntity productosNuevo = iproductosRepo.saveAndFlush(new ProductosMapping().ProductosDtoToProductosEntity(productoDto));
            if(Objects.nonNull(productosNuevo)){
                ProductosDto productosResDto = new ProductosMapping().ProductosEntityToProductosDto(Optional.of(productosNuevo));
                return productosResDto;
            }

        }

        return null;
    }

    @Override
    public ProductosDto actualizaProducto(ProductosDto productoDto) {

        Optional<ProductosEntity> productoExiste = iproductosRepo.findById(productoDto.getIdProducto());

        if (Objects.nonNull(productoExiste)){
            ProductosEntity productoAct = iproductosRepo.saveAndFlush(new ProductosMapping().ProductosDtoToProductosEntity(productoDto));
            if(Objects.nonNull(productoAct)){
                ProductosDto productoResDto = new ProductosMapping().ProductosEntityToProductosDto(Optional.of(productoAct));
                return productoResDto;
            }
        }

        return null;
    }

    @Override
    public String eliminarProducto(ProductosDto productoDto) {

        Optional<ProductosEntity> productoExiste = iproductosRepo.findById(productoDto.getIdProducto());

        if (Objects.nonNull(productoExiste)){
            iproductosRepo.delete(new ProductosMapping().ProductosDtoToProductosEntity(productoDto));
            return "El producto fue eliminado.";
        }
        return null;
    }

    @Override
    public ProductosDto buscarProductoId(Integer idProducto) {

        Optional<ProductosEntity> productoExiste = iproductosRepo.findById(idProducto);
        if (Objects.nonNull(productoExiste)){
            ProductosDto productoResDto = new ProductosMapping().ProductosEntityToProductosDto(productoExiste);
            return productoResDto;
        }

        return null;
    }

    @Override
    public List<ProductosDto> buscarTodosProductos() {
        List<ProductosEntity> productosEntities = iproductosRepo.findAll();
        if(!productosEntities.isEmpty() && productosEntities.size()>0){
            List<ProductosDto> productosDtoList = new ProductosMapping().listProductosEntityTolistProductosDto(productosEntities);
            return productosDtoList;
        }
        return null;
    }

    @Override
    public List<ProductosDto> findAllByFechaProd(String date1, String date2) {
        LocalDate fecha1 = new LocalDateFomatter().dateStringtoLocalDate(date1);
        LocalDate fecha2 = new LocalDateFomatter().dateStringtoLocalDate(date2);

        List<ProductosEntity> productosEntities = iproductosRepo.findByFechaProdBetween(fecha1, fecha2);
        if(!productosEntities.isEmpty() && productosEntities.size()>0){
            List<ProductosDto> productosDtoList = new ProductosMapping().listProductosEntityTolistProductosDto(productosEntities);
            return productosDtoList;
        }
        return null;
    }


}
