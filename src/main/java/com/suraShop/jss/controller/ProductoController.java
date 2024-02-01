package com.suraShop.jss.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suraShop.jss.dto.ProductosDto;
import com.suraShop.jss.service.IproductosService;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiResponse;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/surashop/producto")
@CrossOrigin(origins = "*")
@Log4j2
public class ProductoController {

    private final IproductosService iproductosService;

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se guardó correctamente el producto",response = ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearProducto(@RequestBody @Validated ProductosDto productosDto){
        ProductosDto productosResponse = iproductosService.crearProducto(productosDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(productosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se actualizó correctamente el producto",response =ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarProducto(@RequestBody @Validated ProductosDto productosDto){
        ProductosDto productosResponse = iproductosService.actualizaProducto(productosDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(productosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se eliminó correctamente el producto",response =ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarProducto(@RequestBody @Validated ProductosDto productosDto){
        String productosResponse = iproductosService.eliminarProducto(productosDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(productosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se encontró correctamente el usuario",response =ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarUsuarioId(@RequestBody @Validated ProductosDto productosDto){
        ProductosDto productosResponse = iproductosService.buscarProductoId(productosDto.getIdProducto());
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(productosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se encontró correctamente el usuario",response =ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @GetMapping(value = "/fechaProd",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductosDto>> findAllByFechaProd(@RequestParam(name = "desde") @DateTimeFormat(pattern = "dd/mm/yyyy") String desde,
                                                                 @RequestParam (name = "hasta") @DateTimeFormat(pattern = "dd/mm/yyyy") String hasta)
    {
        List<ProductosDto> productosResponse = iproductosService.findAllByFechaProd(desde, hasta);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productosResponse);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se encontró correctamente el usuario",response =ProductosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @GetMapping(value = "/todos",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductosDto>> buscarTodosProductos()  {
        List<ProductosDto> productosResponse = iproductosService.buscarTodosProductos();
        try {
            return ResponseEntity.status(HttpStatus.OK).body(productosResponse);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}