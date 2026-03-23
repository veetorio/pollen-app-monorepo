package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.LembreteOutput;
import com.nectar.api.domain.models.anotacoes.Lembrete;

@Mapper(componentModel = "spring")
public interface LembretesMapper {
    LembreteOutput lembreteToOutput(Lembrete workspace);

    List<LembreteOutput> lembreteOutputsToOutPut(List<Lembrete> anotacaos);
}
