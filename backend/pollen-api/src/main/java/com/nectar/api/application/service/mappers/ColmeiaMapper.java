package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.workspace.ColmeiaOutput;
import com.nectar.api.domain.models.Colmeia;

@Mapper(componentModel = "spring")
public interface ColmeiaMapper {
    ColmeiaOutput ColmeiaToColmeiaOutput(Colmeia Colmeia);


    List<ColmeiaOutput> ColmeiasToColmeiasOutput(List<Colmeia> Colmeias);
}
