package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.workspace.AnotacaoOutput;
import com.nectar.api.domain.models.anotacoes.Anotacao;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {
    AnotacaoOutput anotacaoToOutput(Anotacao workspace);

    List<AnotacaoOutput> anotacoesToOutPut(List<Anotacao> anotacaos);
}
