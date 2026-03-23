package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.in.UsuarioInput;
import com.nectar.api.controller.out.ContribuidorOutput;
import com.nectar.api.controller.out.empresarial.AdminOutput;
import com.nectar.api.domain.models.Usuario;

@Mapper(componentModel = "spring", uses = {EmpresaMapper.class, WorkspaceMapper.class})
public interface UsuarioMapper {
    
    ContribuidorOutput usuarioInContribuidor(Usuario us);

    AdminOutput usuarioInAdmin(Usuario us);

    Usuario usuarioInputInUsuario(UsuarioInput us);


}
