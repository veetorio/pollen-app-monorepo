package com.nectar.api.controllers.out;

import com.nectar.api.models.Colmeia;
import com.nectar.api.utils.FormatadorDeData;
import lombok.Getter;


@Getter
public class ColmeiaDtoOut {
    private Integer id;
    private String descricao;
    private String dataCriacao;
    private String dataAtualizacao;

    public ColmeiaDtoOut(Colmeia entity) {
        this.id = entity.getIdColmeia();
        this.descricao = entity.getDescricao();

        this.dataCriacao = entity.getDataCriacao().toString();
        this.dataAtualizacao = entity.getDataAtualizacao().toString();
    }

}
