package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.AtividadeRepository;
import com.nectar.api.application.repositorys.EquipeRepository;
import com.nectar.api.application.service.mappers.AtividadeMapper;
import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;
import com.nectar.api.domain.models.empresarial.Atividade;
import com.nectar.api.domain.models.empresarial.Equipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtividadeService {

    private final AtividadeRepository repository;
    private final EquipeRepository equipeRepository;
    private final AtividadeMapper mapper;

    public AtividadeOutput criar(AtividadeDtoIn dtoIn) {
        Equipe equipe = equipeRepository.findByIdPublic(dtoIn.getEquipeIdPublic())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Atividade atividade = mapper.toEntity(dtoIn);
        atividade.setEquipe(equipe);

        return mapper.toOutput(repository.save(atividade));
    }
}
