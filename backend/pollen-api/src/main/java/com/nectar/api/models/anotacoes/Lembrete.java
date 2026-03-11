package com.nectar.api.models.anotacoes;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Lembrete extends Anotacao {
    private LocalDate dataInicio;
    private LocalDate dataTermino;
}
