package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.EquipeDtoIn;
import com.nectar.api.controller.out.empresarial.EquipeOutput;
import com.nectar.api.domain.models.empresarial.Equipe;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {AnotacaoMapper.class})
public interface EquipeMapper {

    public Equipe toEntity(EquipeDtoIn dtoIn);

    public EquipeOutput toOutput(Equipe equipe);
}
