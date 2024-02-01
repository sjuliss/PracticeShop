package com.suraShop.jss.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suraShop.jss.dto.UsuarioDto;
import com.suraShop.jss.service.IusuarioService;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/surashop/usuario")
@CrossOrigin(origins = "*")
@Log4j2
public class UsuarioController {

    private final IusuarioService iusuarioService;

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se guardó correctamente el usuario",response =UsuarioDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearUsuario(@RequestBody @Validated UsuarioDto usuarioDto){
        UsuarioDto usuarioResponse = iusuarioService.crearUsuario(usuarioDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }

    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se actualizó correctamente el usuario",response =UsuarioDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> actualizarUsuario(@RequestBody @Validated UsuarioDto usuarioDto){
        UsuarioDto usuarioResponse = iusuarioService.actualizaUsuario(usuarioDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se eliminó correctamente el usuario",response =UsuarioDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminarUsuario(@RequestBody @Validated UsuarioDto usuarioDto){
        String usuarioResponse = iusuarioService.eliminarUsuario(usuarioDto);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "OK. Se encontró correctamente el usuario",response =UsuarioDto.class),
            @ApiResponse(code = 400,message = "No llenaste los datos correctamente",response = String.class),
            @ApiResponse(code = 500,message = "Error inesperado del sistema")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buscarUsuario(@RequestBody @Validated UsuarioDto usuarioDto){
        UsuarioDto usuarioResponse = iusuarioService.buscarUsuario(usuarioDto);
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ObjectMapper().writeValueAsString(usuarioResponse));
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }


}
