package com.nectar.api.controllers.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoDtoIn {
    private String titulo;
    private String descricao;
    private Integer idColmeiaPai; // O ID para ligar ao ColmeiaService!
}