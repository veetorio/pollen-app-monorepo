package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.AtividadeRepository;
import com.nectar.api.application.repositorys.EquipeRepository;
import com.nectar.api.application.service.gateway.SalvarAnexoStrategy;
import com.nectar.api.application.service.mappers.AtividadeMapper;
import com.nectar.api.controller.in.AnexoInput;
import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;
import com.nectar.api.domain.models.empresarial.Atividade;
import com.nectar.api.domain.models.empresarial.Equipe;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AtividadeService {

    @Autowired
    private  AtividadeRepository repository;
    @Autowired
    private  EquipeRepository equipeRepository;
    @Autowired
    private  AtividadeMapper mapper;

    SalvarAnexoStrategy anexoSt = new AnexosLocalStorageService();

    public AtividadeOutput criar(AtividadeDtoIn dtoIn) {
        Equipe equipe = equipeRepository.findByIdPublic(dtoIn.getEquipeIdPublic())
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        Atividade atividade = mapper.toEntity(dtoIn);
        atividade.setEquipe(equipe);

        return mapper.toOutput(repository.save(atividade));
    }

    public Void salvarAnexo(MultipartFile file, AnexoInput input) {
        int size = equipeRepository
            .findByIdPublic(repository.findByIdPublic(input.getIdAtividade())
            .get()
            .getEquipe()
            .getIdPublic()).get().getAtividades().size();
        if(size == 0) throw new RuntimeException("não possue arquivos"); 
        if(size > 5) throw new RuntimeException("extrapolou a quantidade maxima arquivos");
        Optional<Atividade> atv = repository.findByIdPublic(input.getIdAtividade());

        if(atv.isEmpty()) throw new RuntimeException("a atividade não foi encontrada arquivos");
        

        String paths = anexoSt.salvarAnexo(file,input);
        atv.get().getAnexos().add(paths);

        repository.save(atv.get());
        return null;
    }
}


