package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.EmpresaRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.service.mappers.EmpresaMapper;
import com.nectar.api.controller.in.EmpresaDtoIn;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.empresarial.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaMapper mapper;

    public EmpresaOutput criar(EmpresaDtoIn dtoIn) {
        Empresa empresa = mapper.toEntity(dtoIn);

        Usuario manager = usuarioRepository.findByIdPublic(dtoIn.getManagerIdPublic())
                .orElseThrow(() -> new RuntimeException("Manager não encontrado"));

        empresa.setManager(manager);
        return mapper.toOutput(repository.save(empresa));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Empresa não encontrada para exclusão.");
        }
        repository.deleteById(id);
    }

    public EmpresaOutput atualizar(Long id, EmpresaDtoIn dtoIn) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada para atualização."));

        if (dtoIn.getNome() != null && !dtoIn.getNome().isBlank()) {
            empresa.setNome(dtoIn.getNome());
        }
        // Adicione outros campos conforme necessário

        return mapper.toOutput(repository.save(empresa));
    }
}