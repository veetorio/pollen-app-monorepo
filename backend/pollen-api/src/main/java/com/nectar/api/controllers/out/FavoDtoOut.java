package com.nectar.api.controllers.out;

import com.nectar.api.models.Favo;
import lombok.Getter;

@Getter
public class FavoDtoOut {
    private Integer id;
    private String titulo;
    private String descricao;
    // Não precisamos devolver o ID da Colmeia aqui, pois o contexto já sabe.

    public FavoDtoOut(Favo entity) {
        this.id = entity.getIdFavo();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
    }
}