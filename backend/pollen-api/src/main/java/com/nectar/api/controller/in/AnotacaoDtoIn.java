package com.nectar.api.controller.in;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnotacaoDtoIn {
    private String titulo;
    private String corpo;
    private Integer idCriador;
}
