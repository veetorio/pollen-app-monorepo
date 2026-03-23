package com.nectar.api.controller.out.workspace;

import com.nectar.api.domain.models.Favo;

import lombok.Getter;

@Getter
public class FavoOutput {
    private Integer id;
    private String titulo;
    private String descricao;
    // Não precisamos devolver o ID da Colmeia aqui, pois o contexto já sabe.

    public FavoOutput(Favo entity) {
        this.id = entity.getIdFavo();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
    }
}