package com.nectar.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.models.anotacoes.Tarefa;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findByCriadorIdUsuario(Integer idUsuario);
}
