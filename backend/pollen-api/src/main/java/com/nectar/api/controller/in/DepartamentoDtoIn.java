package com.nectar.api.controller.in;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class DepartamentoDtoIn {
    private String nome;
    private String setor;
    private UUID empresaIdPublic; // Para vincular ao "Pai" (Empresa)
}
