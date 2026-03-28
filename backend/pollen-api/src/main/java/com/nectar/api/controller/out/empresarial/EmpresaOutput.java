package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class EmpresaOutput {
    private String nome;
    private String cnpj;
    private List<DepartamentoOutput> departamentos;
}