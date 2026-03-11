package com.nectar.api.service;

import java.net.URI;

import com.nectar.api.controllers.in.GrupoDtoIn;
import com.nectar.api.models.Grupo;
import com.nectar.api.models.Usuario;
import com.nectar.api.repositorys.GrupoRepository;
import com.nectar.api.repositorys.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.nectar.api.service.cache.CacheTemporaly;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    private final CacheTemporaly<UUID, Long> KEY_AND_VALUES = new CacheTemporaly<>();
    
    @Value("${app.base-url}")
    private String BASE_URL;

    public void criar(GrupoDtoIn dados) {
        Usuario criador = this.usuarioRepository.findById(dados.getIdCriador())
                .orElseThrow(() -> new RuntimeException("Usuário (criador) não encontrado!"));

        if (dados.getNome() == null || dados.getNome().isBlank()) {
            throw new RuntimeException("O nome do grupo é obrigatório.");
        }
        

        Grupo novoGrupo = new Grupo();
        novoGrupo.setNomeDoGrupo(dados.getNome());
        novoGrupo.setCriador(criador);

        this.repository.save(novoGrupo);
    }

    public boolean existeChave(UUID key) {
        Long value = KEY_AND_VALUES.getIfPresent(key);

        return value != null;
    }

    public URI gerarLinkDeConexao(Long idGrupo) {
        if(idGrupo == null) {
            throw new RuntimeException("ID do grupo não pode ser nulo.");
        }
        if(!this.repository.existsById(idGrupo.intValue())) {
            throw new RuntimeException("Grupo não encontrado para gerar link de conexão.");
        }
        UUID uuid = UUID.randomUUID();
        KEY_AND_VALUES.put(uuid, idGrupo);
        return URI.create(BASE_URL + "?link=" + uuid.toString());
    }

    public void conectarAoGrupo(Long idUsuario, UUID key) {
        // implementar depois
        Long idGrupo = KEY_AND_VALUES.getIfPresent(key);
        Usuario usuario = this.usuarioRepository.findById(idUsuario.intValue())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        Grupo grupo = this.repository.findById(idGrupo.intValue())
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado!"));
        if(grupo.getMembros().contains(usuario)) {
            throw new RuntimeException("Usuário já é membro do grupo.");
        }   
        if(grupo.getCriador().getIdUsuario().equals(usuario.getIdUsuario())) {
            throw new RuntimeException("O criador do grupo já é membro por padrão.");
        }


        grupo.getMembros().add(usuario);
        this.repository.save(grupo);
        
    }

    public List<Grupo> listarTodos() {
        return this.repository.findAll();
    }

    public void atualizar(Integer idGrupo, GrupoDtoIn dados) {

        Grupo grupo = this.repository.findById(idGrupo)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado para atualização."));


        if (dados.getNome() == null || dados.getNome().isBlank()) {
            throw new RuntimeException("O nome não pode ser vazio.");
        }

        grupo.setNomeDoGrupo(dados.getNome());

        this.repository.save(grupo);
    }


    public void deletar(Long id) {
        Integer idGrupo = id.intValue(); // Conversão necessária

        if (!this.repository.existsById(idGrupo)) {
            throw new RuntimeException("Grupo não encontrado para exclusão.");
        }

        this.repository.deleteById(idGrupo);
    }
}