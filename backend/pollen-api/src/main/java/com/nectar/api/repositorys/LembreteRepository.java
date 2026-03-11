package com.nectar.api.repositorys;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.models.anotacoes.Lembrete;


public interface LembreteRepository extends JpaRepository<Lembrete, Integer> {
    Optional<Lembrete> findByTitulo(String titulo);
    List<Lembrete> findByCriadorIdUsuario(Integer idUsuario);
}
