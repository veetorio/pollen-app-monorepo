package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.EmpresaDtoIn;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import com.nectar.api.controller.out.workspace.AnotacaoOutput;
import com.nectar.api.domain.models.empresarial.Empresa;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {AnotacaoMapper.class,UsuarioMapper.class})
public interface EmpresaMapper {
  public Empresa toEntity(EmpresaDtoIn dtoIn);

    public EmpresaOutput toOutput(Empresa empresa);
}
