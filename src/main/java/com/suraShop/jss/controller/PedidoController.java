package com.suraShop.jss.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suraShop.jss.dto.PedidosDto;
import com.suraShop.jss.service.IpedidosService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/surashop/pedido")
@CrossOrigin(origins = "*")
@Log4j2
public class PedidoController {

    private final IpedidosService ipedidosService;

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se guardó correctamente el pedido",response = PedidosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPedido(@RequestBody @Validated PedidosDto pedidosDto){
        PedidosDto pedidosResponse = ipedidosService.crearPedido(pedidosDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(pedidosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se eliminó correctamente el pedido",response =PedidosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarPedido(@RequestBody @Validated PedidosDto pedidosDto){
        String pedidosResponse = ipedidosService.eliminarPedido(pedidosDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(pedidosResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se encontró correctamente el pedido",response =PedidosDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @GetMapping(value = "/fechaPedido",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PedidosDto>> findAllByfechaPedido(@RequestParam(name = "desde") @DateTimeFormat(pattern = "dd/mm/yyyy") String desde,
                                                                 @RequestParam (name = "hasta") @DateTimeFormat(pattern = "dd/mm/yyyy") String hasta)
    {
        List<PedidosDto> pedidosResponse = ipedidosService.findAllByfechaPedido(desde, hasta);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pedidosResponse);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
