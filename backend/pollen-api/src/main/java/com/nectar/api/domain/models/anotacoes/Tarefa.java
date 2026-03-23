package com.nectar.api.domain.models.anotacoes;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarefa extends Anotacao {
    private Integer qtdEtapas;
    private Integer atualEtapa;
    private Boolean concluido;
}
