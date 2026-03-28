package com.nectar.api.application.repositorys;

import com.nectar.api.domain.models.empresarial.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    Optional<Equipe> findByIdPublic(UUID idPublic);
}
