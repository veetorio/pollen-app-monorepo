package com.nectar.api.controller.out.empresarial;

import java.util.List;

import com.nectar.api.controller.out.UsuarioOutput;

import lombok.Getter;



@Getter
public class AdminOutput extends UsuarioOutput {
    List<EmpresaOutput> empresas;
}