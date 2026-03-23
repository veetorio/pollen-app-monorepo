package com.nectar.api.application.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.domain.models.anotacoes.Tarefa;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findByIdPublic(UUID work);
}
