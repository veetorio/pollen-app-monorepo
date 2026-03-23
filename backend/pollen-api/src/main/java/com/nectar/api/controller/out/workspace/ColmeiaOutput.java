package com.nectar.api.controller.out.workspace;

import java.util.List;

import com.nectar.api.domain.models.Colmeia;
import com.nectar.api.utils.FormatadorDeData;
import lombok.Getter;


@Getter
public class ColmeiaOutput {
    private Integer id;
    private String descricao;
    private String dataCriacao;
    private String dataAtualizacao;

    List<FavoOutput> favos;

}
