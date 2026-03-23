package com.nectar.api.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nectar.api.application.repositorys.ColmeiaRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.service.usecases.ServiceBaseCases;
import com.nectar.api.controller.in.ColmeiaDtoIn;
import com.nectar.api.domain.models.Colmeia;
import com.nectar.api.domain.models.Usuario;


import jakarta.annotation.Nonnull;

@Service
public class ColmeiaService implements ServiceBaseCases<Colmeia> {
    @Autowired
    private ColmeiaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(ColmeiaDtoIn dados) {
        Usuario criador = this.usuarioRepository.findByIdPublic(dados.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário (criador) não encontrado!"));

        if (dados.getDescricao() == null || dados.getDescricao().isBlank()) {
            throw new RuntimeException("A descrição da colmeia é obrigatória.");
        }

        Colmeia novaColmeia = new Colmeia();
        novaColmeia.setDescricao(dados.getDescricao());
        novaColmeia.setCriadorDaColmeia(criador);

        this.salvar(novaColmeia);
    }
    
    @Override
    public void salvar(@Nonnull Colmeia entity) {
        // colocar validação de quantidade de caracteres

        repository.save(entity);
    }

    @Override
    public void deletar(@Nonnull Long id) {
        Integer idColmeia = id.intValue();

        if (!this.repository.existsById(idColmeia)) {
            throw new RuntimeException("Colmeia não encontrada.");
        }
        this.repository.deleteById(idColmeia);
    }

    @Override
    public List<Colmeia> listar() {
        return this.repository.findAll();
    }

    @Override
    public Colmeia buscarPorNome(String alvo) {
        // A colmeia não tem nome
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void atualizarDescricao(Integer idColmeia, ColmeiaDtoIn dados) {
        Colmeia colmeia = this.repository.findById(idColmeia)
                .orElseThrow(() -> new RuntimeException("Colmeia não encontrada para atualização."));

        if (dados.getDescricao() == null || dados.getDescricao().isBlank()) {
            throw new RuntimeException("A descrição não pode ser vazia. Por favor, forneça um nome.");
        }

        colmeia.setDescricao(dados.getDescricao());

        this.repository.save(colmeia);
    }
}
