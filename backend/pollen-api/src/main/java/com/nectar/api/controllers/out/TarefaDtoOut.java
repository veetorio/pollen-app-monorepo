package com.nectar.api.controllers.out;

import com.nectar.api.models.anotacoes.Tarefa;
import lombok.Getter;

@Getter
public class TarefaDtoOut {
    // Campos Herdados
    private String titulo;
    private String corpo;

    private Integer qtdEtapas;
    private Integer atualEtapa;
    private Boolean concluido;

    public TarefaDtoOut(Tarefa entity) {
        this.titulo = entity.getTitulo();
        this.corpo = entity.getCorpo();
        this.qtdEtapas = entity.getQtdEtapas();
        this.atualEtapa = entity.getAtualEtapa();
        this.concluido = entity.getConcluido();
    }
}
