package com.nectar.api.controllers.out;

import java.util.List;
import java.util.stream.Collectors;

import com.nectar.api.models.Grupo;

import lombok.Getter;

@Getter
public class GrupoDtoOut {
    private Integer id;
    private String nome;
    private UsuarioDtoOut criador;
    private List<UsuarioDtoOut> membros;

    public GrupoDtoOut(Grupo entity) {
        this.id = entity.getIdGrupo();
        this.nome = entity.getNomeDoGrupo();
        this.criador = new UsuarioDtoOut(entity.getCriador());
        this.membros = entity.getMembros().stream().map(UsuarioDtoOut::new).collect(Collectors.toList());
    }
}
