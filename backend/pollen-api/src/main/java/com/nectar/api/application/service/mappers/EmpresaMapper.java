package com.nectar.api.application.service.mappers;

import com.nectar.api.controller.in.EmpresaDtoIn;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import com.nectar.api.domain.models.empresarial.Empresa;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class EmpresaMapper {

    public Empresa toEntity(EmpresaDtoIn dtoIn) {
        if (dtoIn == null) return null;

        Empresa empresa = new Empresa();

        empresa.setNome(dtoIn.getNome());
        empresa.setCnpj(dtoIn.getCnpj());

        return empresa;
    }

    public EmpresaOutput toOutput(Empresa empresa) {
        if (empresa == null) return null;

        EmpresaOutput out = new EmpresaOutput();

        out.setNome(empresa.getNome());

        out.setCnpj(String.valueOf(empresa.getCnpj()));

        out.setDepartamentos(new ArrayList<>());

        return out;
    }
}
