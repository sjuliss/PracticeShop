package com.suraShop.jss.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    @JsonProperty("id_usuario")
    private int idUsuario;

    @JsonProperty("cedula")
    private String cedula;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("email")
    private String email;
}
