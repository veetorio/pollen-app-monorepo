package com.nectar.api.controller.in;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaDtoIn {
    private String titulo;
    private String corpo;
    private UUID publicIdWork; // Quem está criando

    private Integer qtdEtapas;
}
