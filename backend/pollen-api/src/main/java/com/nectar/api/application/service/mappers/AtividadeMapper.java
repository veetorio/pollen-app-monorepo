package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;
import com.nectar.api.domain.models.empresarial.Atividade;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {AnotacaoMapper.class})
public interface AtividadeMapper {

    @Mapping(target = "anexos",ignore = true)
    public Atividade toEntity(AtividadeDtoIn dtoIn);

    public AtividadeOutput toOutput(Atividade atividade);
}
