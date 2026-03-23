package com.nectar.api.application.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.domain.models.Colmeia;

public interface ColmeiaRepository extends JpaRepository<Colmeia, Integer> {
}
