package com.nectar.api.application.repositorys;

import com.nectar.api.domain.models.empresarial.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByIdPublic(UUID idPublic);
}