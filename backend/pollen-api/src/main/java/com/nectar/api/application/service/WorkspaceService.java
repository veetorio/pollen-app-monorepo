package com.nectar.api.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.repositorys.WorkspaceRepository;
import com.nectar.api.controller.in.WorkSpaceInput;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.Workspace;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Void criarWorkspace(WorkSpaceInput wk) {
        Optional<Usuario> varUsuario = usuarioRepository.findByIdPublic(wk.getPublicKeyUsuario());
        if (varUsuario.isEmpty()) {
            throw new RuntimeException("Usuario não encontrado");
        }   
        Usuario usuario = varUsuario.get();
        List<Workspace> workspaces = usuario.getWorkspaces();
        Workspace workspace = new Workspace();
        workspace.setNome(wk.getNome());
        workspace.setCriador(usuario);
        workspaces.add(workspace);

        usuario.setWorkspaces(workspaces);

        workspaceRepository.save(workspace);
        usuarioRepository.save(usuario);

        return null;
    }

    public void deletar(Long id) {
        if (!workspaceRepository.existsById(id)) {
            throw new RuntimeException("Workspace não encontrada para exclusão.");
        }
        workspaceRepository.deleteById(id);
    }

    public Workspace atualizar(Long id, String nome) {
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workspace não encontrada para atualização."));

        if (nome != null && !nome.isBlank()) {
            workspace.setNome(nome);
        }
        // Adicione outros campos conforme necessário

        return workspaceRepository.save(workspace);
    }
        
    
}
