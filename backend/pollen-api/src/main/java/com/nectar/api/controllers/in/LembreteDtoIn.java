package com.nectar.api.controllers.in;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class LembreteDtoIn {
    // Herdados
    private String titulo;
    private String corpo;
    private Integer idCriador;

    // Específicos
    private LocalDate dataInicio;
    private LocalDate dataTermino;
}