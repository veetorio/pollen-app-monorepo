package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.DepartamentoDtoIn;
import com.nectar.api.controller.out.empresarial.DepartamentoOutput;
import com.nectar.api.domain.models.empresarial.Departamento;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoDtoIn dtoIn) {
        if (dtoIn == null) return null;
        Departamento departamento = new Departamento();
        departamento.setNome(dtoIn.getNome());
        departamento.setSetor(dtoIn.getSetor());
        return departamento;
    }

    public DepartamentoOutput toOutput(Departamento departamento) {
        if (departamento == null) return null;
        DepartamentoOutput out = new DepartamentoOutput();
        out.setNome(departamento.getNome());
        out.setSetor(departamento.getSetor());
        // Inicializa a lista de equipes para evitar NullPointerException no front
        out.setEquipes(new ArrayList<>());
        return out;
    }
}
