package com.nectar.api.application.service.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.nectar.api.controller.out.LembreteOutput;
import com.nectar.api.controller.out.TarefaOutput;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import com.nectar.api.controller.out.workspace.AnotacaoOutput;
import com.nectar.api.controller.out.workspace.WorkspaceOutput;
import com.nectar.api.domain.models.Workspace;
import com.nectar.api.domain.models.anotacoes.Lembrete;
import com.nectar.api.domain.models.empresarial.Empresa;

@Mapper(componentModel = "spring",uses = {TarefaMapper.class,AnotacaoMapper.class,LembretesMapper.class})
public interface WorkspaceMapper {
    WorkspaceOutput workspaceToOutput(Workspace workspace);

    List<WorkspaceOutput> WorkspacesToWorkspacesOutput(List<Workspace> workspaces);
}
