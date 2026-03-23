package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import com.nectar.api.domain.models.empresarial.Empresa;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaOutput empresaToEmpresaOutput(Empresa empresa);

    List<EmpresaOutput> empresasToEmpresasOutput(List<Empresa> empresas);
}
