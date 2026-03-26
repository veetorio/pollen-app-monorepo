package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.EquipeDtoIn;
import com.nectar.api.controller.out.empresarial.EquipeOutput;
import com.nectar.api.domain.models.empresarial.Equipe;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class EquipeMapper {

    public Equipe toEntity(EquipeDtoIn dtoIn) {
        if (dtoIn == null) return null;
        Equipe equipe = new Equipe();
        equipe.setNome(dtoIn.getNome());
        return equipe;
    }

    public EquipeOutput toOutput(Equipe equipe) {
        if (equipe == null) return null;
        EquipeOutput out = new EquipeOutput();
        out.setNome(equipe.getNome());
        // Inicializa a lista de atividades para o front-end
        out.setAtividades(new ArrayList<>());
        return out;
    }
}
