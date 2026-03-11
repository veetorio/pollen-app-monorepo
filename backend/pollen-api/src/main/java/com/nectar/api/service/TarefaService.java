package com.nectar.api.service;

import com.nectar.api.controllers.in.TarefaDtoIn;
import com.nectar.api.controllers.out.TarefaDtoOut;
import com.nectar.api.models.Usuario;
import com.nectar.api.models.anotacoes.Tarefa;
import com.nectar.api.repositorys.TarefaRepository;
import com.nectar.api.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(TarefaDtoIn dados) {

        Usuario criador = this.usuarioRepository.findById(dados.getIdCriador())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado!"));

        if (dados.getTitulo() == null || dados.getTitulo().isBlank() || dados.getQtdEtapas() == null) {
            throw new RuntimeException("Título e quantidade de etapas são obrigatórios.");
        }

        Tarefa novaTarefa = new Tarefa();

        novaTarefa.setTitulo(dados.getTitulo());
        novaTarefa.setCorpo(dados.getCorpo());
        novaTarefa.setCriador(criador); // LIGAÇÃO
        novaTarefa.setLixo(false);

        novaTarefa.setQtdEtapas(dados.getQtdEtapas());
        novaTarefa.setAtualEtapa(0);
        novaTarefa.setConcluido(false);

        this.repository.save(novaTarefa);
    }


    public List<TarefaDtoOut> listarPorUsuario(Integer idUsuario) {

        List<Tarefa> tarefasDoBanco = this.repository.findByCriadorIdUsuario(idUsuario);

        return tarefasDoBanco.stream()
                .map(TarefaDtoOut::new)
                .collect(java.util.stream.Collectors.toList());
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