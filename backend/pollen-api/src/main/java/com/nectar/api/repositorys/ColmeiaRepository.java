package com.nectar.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.models.Colmeia;

public interface ColmeiaRepository extends JpaRepository<Colmeia, Integer> {
    
}
