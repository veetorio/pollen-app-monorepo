package com.nectar.api.controllers.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDtoIn {
    private String titulo;
    private String corpo;
    private Integer idCriador; // Quem está criando

    private Integer qtdEtapas;
}
