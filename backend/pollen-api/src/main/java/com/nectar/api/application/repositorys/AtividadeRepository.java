package com.nectar.api.application.repositorys;

import com.nectar.api.domain.models.empresarial.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    Optional<Atividade> findByIdPublic(UUID idPublic);
}
