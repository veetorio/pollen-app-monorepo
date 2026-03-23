package com.nectar.api.application.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nectar.api.domain.models.Workspace;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface WorkspaceRepository extends JpaRepository<Workspace, Long>  {

    Optional<Workspace> findByIdPublic(UUID idPublic);
} 