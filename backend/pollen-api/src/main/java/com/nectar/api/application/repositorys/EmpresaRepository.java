package com.nectar.api.application.repositorys;

import com.nectar.api.domain.models.empresarial.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Optional<Empresa> findByIdPublic(UUID idPublic);
}
