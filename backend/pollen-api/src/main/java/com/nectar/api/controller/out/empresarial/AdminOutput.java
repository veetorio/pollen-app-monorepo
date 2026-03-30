package com.nectar.api.controller.out.empresarial;

import java.util.List;

import com.nectar.api.controller.out.UsuarioOutput;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AdminOutput extends UsuarioOutput {
    List<EmpresaOutput> empresas;
}