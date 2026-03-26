package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter // Adicionado para permitir que o EquipeMapper popule o DTO
public class EquipeOutput {

    private String nome;

    private UUID idPublic;

    // Lista de atividades vinculadas a esta equipe
    private List<AtividadeOutput> atividades;

    // Se você quiser expor os nomes ou UUIDs dos membros no futuro,
    // a lista viria aqui. Por enquanto, mantemos o foco na estrutura base.
}