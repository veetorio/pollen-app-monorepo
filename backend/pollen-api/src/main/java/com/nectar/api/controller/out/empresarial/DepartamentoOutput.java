package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class DepartamentoOutput {
    private String nome;
    private String setor;

    private List<EquipeOutput> equipes;
}