package com.nectar.api.controllers.out;

import java.time.LocalDate;

import com.nectar.api.models.anotacoes.Lembrete;
import com.nectar.api.service.LembreteService;

import lombok.Getter;

@Getter
public class LembreteDtoOUT {
    private STATUS_LEMBRETE status;
    private LocalDate inicio;
    private LocalDate termino;
    private String titulo;
    private String corpo;
    private Integer diasRestantes;

    public LembreteDtoOUT(Lembrete lembrete) {
        this.inicio = lembrete.getDataInicio();
        this.termino = lembrete.getDataTermino();
        this.titulo = lembrete.getTitulo();
        this.corpo = lembrete.getCorpo();
        this.diasRestantes = LembreteService.calcularDiasRestantes(lembrete.getDataInicio(),lembrete.getDataTermino());
        this.status = STATUS_LEMBRETE.ATIVO;
    }

    public void setStatus(int days) {
        if (days > 2) {
            this.status = STATUS_LEMBRETE.ATIVO;
        } else if(days > 0 && days <= 2) {
            this.status = STATUS_LEMBRETE.PROXIMO;
        } else {
            this.status = STATUS_LEMBRETE.INATIVO;
        }
    }
}
