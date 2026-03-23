package com.nectar.api.controller.out.workspace;

import java.util.List;
import java.util.UUID;

import com.nectar.api.controller.out.LembreteOutput;
import com.nectar.api.controller.out.TarefaOutput;
import com.nectar.api.domain.models.anotacoes.Lembrete;
import com.nectar.api.domain.models.anotacoes.Tarefa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkspaceOutput{

    private UUID idPublic;
    
    private String nome;

    private List<AnotacaoOutput> anotacoes;

    private List<TarefaOutput> tarefas;

    private List<LembreteOutput> lembrete;
}
