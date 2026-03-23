package com.nectar.api.controller.out;

import com.nectar.api.domain.models.anotacoes.Tarefa;

import lombok.Getter;

@Getter
public class TarefaOutput {
    // Campos Herdados
    private String titulo;
    private String corpo;

    private Integer qtdEtapas;
    private Integer atualEtapa;
    private Boolean concluido;

    public TarefaOutput(Tarefa entity) {
        this.titulo = entity.getTitulo();
        this.corpo = entity.getCorpo();
        this.qtdEtapas = entity.getQtdEtapas();
        this.atualEtapa = entity.getAtualEtapa();
        this.concluido = entity.getConcluido();
    }
}
