package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import com.nectar.api.controller.in.UsuarioInput;
import com.nectar.api.controller.out.ContribuidorEquipeOutPut;
import com.nectar.api.controller.out.ContribuidorOutput;
import com.nectar.api.controller.out.empresarial.AdminOutput;
import com.nectar.api.domain.models.Usuario;

@Mapper(componentModel = "spring", uses = { EmpresaMapper.class, WorkspaceMapper.class  , DepartamentoMapper.class})
public interface UsuarioMapper {

    @Named("usuarioInContribuidor")
    ContribuidorOutput usuarioInContribuidor(Usuario us);

    @Named("usuarioInContribuidorEquipe")
    ContribuidorEquipeOutPut usuarioInContribuidorEquipe(Usuario us);

    AdminOutput usuarioInAdmin(Usuario us);

    Usuario usuarioInputInUsuario(UsuarioInput us);

}
