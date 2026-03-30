package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EmpresaOutput {
    private UUID idPublic;
    private String nome;
    private String cnpj;
    private List<DepartamentoOutput> departamentos;
}