package com.nectar.api.application.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nectar.api.domain.models.anotacoes.Anotacao;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Integer> {

    @Query("SELECT a FROM Anotacao a WHERE a.workspace.criador.idPrivate = :idUsuario")
    List<Anotacao> findByCriadorIdUsuario(@Param("idUsuario") Integer idUsuario);
}
