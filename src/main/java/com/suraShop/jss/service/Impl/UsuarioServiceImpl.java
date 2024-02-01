package com.suraShop.jss.service.Impl;


import com.suraShop.jss.Entity.UsuarioEntity;
import com.suraShop.jss.dto.UsuarioDto;
import com.suraShop.jss.mapping.UsuarioMapping;
import com.suraShop.jss.repository.IusuarioRepo;
import com.suraShop.jss.service.IusuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements IusuarioService {

    private final IusuarioRepo iusuarioRepo;
    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioDto){

        UsuarioEntity cedula = iusuarioRepo.findBycedula(usuarioDto.getCedula());

        if (Objects.isNull(cedula)){
            UsuarioEntity usuarioNuevo = iusuarioRepo.saveAndFlush(new UsuarioMapping().UsuarioDtoToUsuarioEntity(usuarioDto));
            if (Objects.nonNull(usuarioNuevo)){
                UsuarioDto usuarioResDTO = new UsuarioMapping().UsuarioEntityToUsuarioDto(usuarioNuevo);
                return usuarioResDTO;
            }

        }
        return null;

    }

    @Override
    public UsuarioDto actualizaUsuario(UsuarioDto usuarioDto) {

        UsuarioEntity usuarioExiste = iusuarioRepo.findBycedula(usuarioDto.getCedula());

        if(Objects.nonNull(usuarioExiste)){
            UsuarioEntity usuarioAct = iusuarioRepo.saveAndFlush(new UsuarioMapping().UsuarioDtoToUsuarioEntity(usuarioDto));
            if (Objects.nonNull(usuarioAct)){
                UsuarioDto usuarioActDto = new UsuarioMapping().UsuarioEntityToUsuarioDto(usuarioAct);
                return usuarioActDto;
            }
        }

        return null;
    }

    @Override
    public String eliminarUsuario(UsuarioDto usuarioDto) {

        UsuarioEntity usuarioBuscar = iusuarioRepo.findBycedula(usuarioDto.getCedula());

        if(Objects.nonNull(usuarioBuscar)){
            iusuarioRepo.delete(new UsuarioMapping().UsuarioDtoToUsuarioEntity(usuarioDto));
            return "El usuario fue eliminado de la base de datos.";
        }

        return null;
    }

    @Override
    public Integer buscarUsuarioId(Integer idUsuario) {

        Optional<UsuarioEntity> usuarioBuscar = iusuarioRepo.findById(idUsuario);

        if(Objects.nonNull(usuarioBuscar)){
            return usuarioBuscar.get().getIdUsuario();
        }

        return -1;
    }

    @Override
    public UsuarioDto buscarUsuario(UsuarioDto usuarioDto) {

        UsuarioEntity usuarioBuscar = iusuarioRepo.findBycedula(usuarioDto.getCedula());

        if (Objects.nonNull(usuarioBuscar)){
            return new UsuarioMapping().UsuarioEntityToUsuarioDto(usuarioBuscar);
        }

        return usuarioDto;
    }

}
