package com.nectar.api.controllers.out;

import com.nectar.api.models.anotacoes.Anotacao;
import lombok.Getter;

@Getter
public class AnotacaoDtoOut {

    private Integer id;
    private String titulo;
    private String corpo;

    public AnotacaoDtoOut(Anotacao entity) {
        this.id = entity.getId_anotacao();
        this.titulo = entity.getTitulo();
        this.corpo = entity.getCorpo();
    }
}
