package com.nectar.api.controller.out;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.nectar.api.controller.out.workspace.WorkspaceOutput;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioOutput {
    protected UUID idPublic;
    protected String nome;
    protected String email;
    protected Instant criadoEm;
    protected Instant atualizadoEm;
    protected TokenOutput authToken;
    protected List<WorkspaceOutput> workspaces;
}
