package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

import com.nectar.api.controller.out.ContribuidorEquipeOutPut;

@Getter
@Setter 
public class EquipeOutput {

    private String nome;

    private UUID idPublic;

    // Lista de atividades vinculadas a esta equipe
    private List<AtividadeOutput> atividades;

    private List<ContribuidorEquipeOutPut> contribuidores;


}