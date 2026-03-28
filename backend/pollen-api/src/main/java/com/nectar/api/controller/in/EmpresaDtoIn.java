package com.nectar.api.controller.in;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class EmpresaDtoIn {
    private String nome;
    private int cnpj;
    private UUID managerIdPublic;
}
