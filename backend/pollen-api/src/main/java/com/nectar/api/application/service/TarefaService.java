package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.TarefaRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.repositorys.WorkspaceRepository;
import com.nectar.api.controller.in.TarefaDtoIn;
import com.nectar.api.controller.out.TarefaOutput;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.Workspace;
import com.nectar.api.domain.models.anotacoes.Tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;
    @Autowired
    private WorkspaceRepository usuarioRepository;

    public void criar(TarefaDtoIn dados) {

        Workspace criador = this.usuarioRepository.findByIdPublic(dados.getPublicIdWork())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado!"));

        if (dados.getTitulo() == null || dados.getTitulo().isBlank() || dados.getQtdEtapas() == null) {
            throw new RuntimeException("Título e quantidade de etapas são obrigatórios.");
        }

        Tarefa novaTarefa = new Tarefa();

        novaTarefa.setTitulo(dados.getTitulo());
        novaTarefa.setCorpo(dados.getCorpo());
        novaTarefa.setLixo(false);

        novaTarefa.setQtdEtapas(dados.getQtdEtapas());
        novaTarefa.setAtualEtapa(0);
        novaTarefa.setConcluido(false);

        criador.getAnotacoes().add(novaTarefa);
        this.usuarioRepository.save(criador);

        this.repository.save(novaTarefa);
    }



    /**
     * UPDATE: Atualizar dados e status da Tarefa
     */
    public void atualizar(Integer idTarefa, TarefaDtoIn dados) {

        Tarefa tarefa = this.repository.findById(Long.valueOf(idTarefa))
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));

        if (dados.getTitulo() != null && !dados.getTitulo().isBlank()) {
            tarefa.setTitulo(dados.getTitulo());
        }
        if (dados.getCorpo() != null) {
            tarefa.setCorpo(dados.getCorpo());
        }

        if (dados.getQtdEtapas() != null) tarefa.setQtdEtapas(dados.getQtdEtapas());

        this.repository.save(tarefa);
    }


    public void deletar(Integer id) {
        if (!this.repository.existsById(Long.valueOf(id))) {
            throw new RuntimeException("Tarefa não encontrada para exclusão.");
        }
        this.repository.deleteById(Long.valueOf(id));
    }

}