package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.DepartamentoRepository;
import com.nectar.api.application.repositorys.EmpresaRepository;
import com.nectar.api.application.service.mappers.DepartamentoMapper;
import com.nectar.api.controller.in.DepartamentoDtoIn;
import com.nectar.api.controller.out.empresarial.DepartamentoOutput;
import com.nectar.api.domain.models.empresarial.Departamento;
import com.nectar.api.domain.models.empresarial.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final EmpresaRepository empresaRepository;
    private final DepartamentoMapper mapper;

    public DepartamentoOutput criar(DepartamentoDtoIn dtoIn) {
        Departamento departamento = mapper.toEntity(dtoIn);

        // O departamento precisa de uma empresa existente
        Empresa empresa = empresaRepository.findByIdPublic(dtoIn.getEmpresaIdPublic())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para este departamento."));

        departamento.setEmpresa(empresa);
        return mapper.toOutput(repository.save(departamento));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Departamento não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }

    public DepartamentoOutput atualizar(Long id, DepartamentoDtoIn dtoIn) {
        Departamento departamento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado para atualização."));

        if (dtoIn.getNome() != null && !dtoIn.getNome().isBlank()) {
            departamento.setNome(dtoIn.getNome());
        }
        // Adicione outros campos conforme necessário

        return mapper.toOutput(repository.save(departamento));
    }
}
