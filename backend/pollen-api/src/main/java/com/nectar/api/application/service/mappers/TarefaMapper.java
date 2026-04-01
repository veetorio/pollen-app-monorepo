package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.TarefaOutput;
import com.nectar.api.controller.out.workspace.AnotacaoOutput;
import com.nectar.api.domain.models.anotacoes.Anotacao;
import com.nectar.api.domain.models.anotacoes.Tarefa;

@Mapper(componentModel = "spring",uses = {AnotacaoMapper.class})
public interface TarefaMapper {
    TarefaOutput anotacaoToOutput(Tarefa workspace);

    List<TarefaOutput> anotacoesToOutPut(List<TarefaOutput> anotacaos);
}
