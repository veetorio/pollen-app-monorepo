package com.nectar.api.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.models.anotacoes.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Integer> {

    List<Anotacao> findByCriadorIdUsuario(Integer idUsuario);
}
