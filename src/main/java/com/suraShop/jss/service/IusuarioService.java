package com.suraShop.jss.service;

import com.suraShop.jss.dto.UsuarioDto;

public interface IusuarioService {
    UsuarioDto crearUsuario(UsuarioDto usuarioDto);
    UsuarioDto actualizaUsuario(UsuarioDto usuarioDto);
    String eliminarUsuario(UsuarioDto usuarioDto);

    Integer buscarUsuarioId(Integer idUsuario);
    UsuarioDto buscarUsuario(UsuarioDto usuarioDto);

}
