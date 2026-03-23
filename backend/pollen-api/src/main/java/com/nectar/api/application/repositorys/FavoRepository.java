package com.nectar.api.application.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.domain.models.Favo;


public interface FavoRepository extends JpaRepository<Favo, Integer> {
    Optional<Favo> findByTitulo(String alvo);
}
