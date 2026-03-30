package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class DepartamentoOutput {
    private UUID idPublic;
    private String nome;
    private String setor;

    private List<EquipeOutput> equipes;
}