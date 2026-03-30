package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.DepartamentoDtoIn;
import com.nectar.api.controller.out.empresarial.DepartamentoOutput;
import com.nectar.api.domain.models.empresarial.Departamento;

import org.mapstruct.Mapper;
import java.util.ArrayList;

@Mapper(componentModel = "spring",uses = {AnotacaoMapper.class})
public interface DepartamentoMapper {

    public Departamento toEntity(DepartamentoDtoIn dtoIn);

    public DepartamentoOutput toOutput(Departamento departamento);
}
