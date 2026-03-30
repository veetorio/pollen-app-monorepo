package com.nectar.api.controller.in;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AtividadeDtoIn {
    private String head;
    private String content;
    private UUID equipeIdPublic; // UUID da equipe dona da atividade
}
