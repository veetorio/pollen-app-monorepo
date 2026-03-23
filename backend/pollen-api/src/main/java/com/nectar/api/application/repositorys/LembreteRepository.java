package com.nectar.api.application.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nectar.api.domain.models.anotacoes.Lembrete;


public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {
    Optional<Lembrete> findByTitulo(String titulo);
    
    @Query("SELECT l FROM Lembrete l WHERE l.workspace.criador.idPrivate = :idUsuario")
    List<Lembrete> findByCriadorIdUsuario(@Param("idUsuario") Integer idUsuario);
}
