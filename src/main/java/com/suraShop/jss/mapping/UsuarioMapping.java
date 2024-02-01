package com.suraShop.jss.mapping;

import com.suraShop.jss.Entity.UsuarioEntity;
import com.suraShop.jss.dto.UsuarioDto;

public class UsuarioMapping {

    public UsuarioEntity UsuarioDtoToUsuarioEntity(UsuarioDto usuarioDTO){
        return UsuarioEntity.builder()
                .idUsuario(usuarioDTO.getIdUsuario())
                .cedula(usuarioDTO.getCedula())
                .nombre(usuarioDTO.getNombre())
                .email(usuarioDTO.getEmail())
                .build();
    }

    public UsuarioDto UsuarioEntityToUsuarioDto(UsuarioEntity usuarioEntity){
        return UsuarioDto.builder()
                .idUsuario(usuarioEntity.getIdUsuario())
                .cedula(usuarioEntity.getCedula())
                .nombre(usuarioEntity.getNombre())
                .email(usuarioEntity.getEmail())
                .build();
    }

}
