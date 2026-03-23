package com.nectar.api.controller.out.empresarial;

import java.util.List;

import com.nectar.api.controller.out.ContribuidorOutput;
import com.nectar.api.domain.models.empresarial.Atividade;

public class EquipeOutput {
    private String nome;
    private String lider;

    private List<ContribuidorOutput> membros;
    private List<AtividadeOutput> projetos;
}