package com.nectar.api.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.models.Favo;


public interface FavoRepository extends JpaRepository<Favo, Integer> {
    Optional<Favo> findBytitulo(String alvo);
    Optional<Favo> findByTitulo(String alvo);
}
