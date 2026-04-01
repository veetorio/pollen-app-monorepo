package com.nectar.api.application.service;

import com.nectar.api.application.repositorys.DepartamentoRepository;
import com.nectar.api.application.repositorys.EquipeRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.service.mappers.EquipeMapper;
import com.nectar.api.controller.in.EquipeDtoIn;
import com.nectar.api.controller.out.empresarial.EquipeOutput;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.empresarial.Departamento;
import com.nectar.api.domain.models.empresarial.Equipe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipeService {

    private final EquipeRepository repository;
    private final DepartamentoRepository departamentoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EquipeMapper mapper;

    public EquipeOutput criar(EquipeDtoIn dtoIn) {
        // 1. Validar Departamento
        Departamento depto = departamentoRepository.findByIdPublic(dtoIn.getDepartamentoIdPublic())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        // 2. Buscar Usuários Contribuidores (ManyToMany)
        List<Usuario> usuarios = dtoIn.getContribuidoresIds().stream()
                .map(uuid -> usuarioRepository.findByIdPublic(uuid)
                        .orElseThrow(() -> new RuntimeException("Usuário não encontrado: " + uuid)))
                .collect(Collectors.toList());

        // 3. Mapear e Salvar
        Equipe equipe = mapper.toEntity(dtoIn);
        equipe.setDepartamento(depto);
        equipe.setContribuidores(usuarios);

        return mapper.toOutput(repository.save(equipe));
    }

        public void deletar(Long id) {
                if (!repository.existsById(id)) {
                        throw new RuntimeException("Equipe não encontrada para exclusão.");
                }
                repository.deleteById(id);
        }

        public EquipeOutput atualizar(Long id, EquipeDtoIn dtoIn) {
                Equipe equipe = repository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Equipe não encontrada para atualização."));

                if (dtoIn.getNome() != null && !dtoIn.getNome().isBlank()) {
                        equipe.setNome(dtoIn.getNome());
                }
                // Adicione outros campos conforme necessário

                return mapper.toOutput(repository.save(equipe));
        }
}