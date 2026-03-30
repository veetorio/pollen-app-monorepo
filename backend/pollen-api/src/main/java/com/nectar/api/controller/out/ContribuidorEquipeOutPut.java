package com.nectar.api.controller.out;


import java.time.Instant;
import java.util.UUID;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ContribuidorEquipeOutPut  {
    protected UUID idPublic;
    protected String nome;
    protected String email;
    protected Instant criadoEm;
    protected Instant atualizadoEm;
}
