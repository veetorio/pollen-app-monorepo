package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;
import com.nectar.api.domain.models.empresarial.Atividade;
import org.springframework.stereotype.Component;

@Component
public class AtividadeMapper {

    public Atividade toEntity(AtividadeDtoIn dtoIn) {
        if (dtoIn == null) return null;
        Atividade atividade = new Atividade();
        atividade.setHead(dtoIn.getHead());
        atividade.setContent(dtoIn.getContent());
        atividade.setAnexos(dtoIn.getAnexos());
        return atividade;
    }

    public AtividadeOutput toOutput(Atividade atividade) {
        if (atividade == null) return null;
        AtividadeOutput out = new AtividadeOutput();
        out.setIdPublic(atividade.getIdPublic());
        out.setHead(atividade.getHead());
        out.setContent(atividade.getContent());
        out.setAnexos(atividade.getAnexos());
        return out;
    }
}
