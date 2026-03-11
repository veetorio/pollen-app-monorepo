package com.nectar.api.controllers.out;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

import com.nectar.api.models.Usuario;
import com.nectar.api.utils.FormatadorDeData;


import lombok.Getter;
@Getter
public class UsuarioDtoOut {
    private Integer id;
    private String nome;
    private String email;
    private String criadoEm;
    private String atualizadoEm;

    public UsuarioDtoOut(Usuario entity){
        this.id = entity.getIdUsuario();
        this.atualizadoEm = entity.getDataAtualizacao() != null
                ? FormatadorDeData.formatarData(entity.getDataAtualizacao())
                : null;
        this.criadoEm = FormatadorDeData.formatarData(entity.getDataCriacao());
        this.email = entity.getEmail();
        this.nome  = entity.getNome();
    }


}
