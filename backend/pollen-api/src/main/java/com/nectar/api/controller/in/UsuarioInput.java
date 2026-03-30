package com.nectar.api.controller.in;
import java.util.UUID;

import javax.management.relation.Role;

import com.nectar.api.utils.RoleUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
    private UUID idPublic;
    private String email;
    private String senha;
    private String nome;
    private RoleUsuario tipo;
}
