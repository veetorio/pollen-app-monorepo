package com.nectar.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nectar.api.controllers.in.AnotacaoDtoIn;
import com.nectar.api.controllers.out.AnotacaoDtoOut;
import com.nectar.api.models.Usuario;
import com.nectar.api.models.anotacoes.Anotacao;
import com.nectar.api.repositorys.AnotacaoRepository;
import com.nectar.api.repositorys.UsuarioRepository;
import com.nectar.api.service.usecases.ServiceBaseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnotacaoService implements ServiceBaseCases<Anotacao>   {

    private final AnotacaoRepository anotacaoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AnotacaoService(AnotacaoRepository anotacaoRepository, UsuarioRepository usuarioRepository) {
        this.anotacaoRepository = anotacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Anotação não precisa de título obrigatoriamente
    public void criar(AnotacaoDtoIn dados) {
        Usuario criador = this.usuarioRepository.findById(dados.getIdCriador())
                .orElseThrow(() -> new RuntimeException("Usuário criador não encontrado!"));

        Anotacao novaAnotacao = new Anotacao();
        novaAnotacao.setTitulo(dados.getTitulo());
        novaAnotacao.setCorpo(dados.getCorpo());
        novaAnotacao.setLixo(false);

        novaAnotacao.setCriador(criador);

        this.salvar(novaAnotacao);
    }


    @Override
    public void salvar(Anotacao entity) {
        // validação de anotação
        if(entity.getCorpo().isBlank() && entity.getTitulo().isBlank()) {
            throw new RuntimeException("erro de formatação");
        }
        if(entity.getCorpo().replaceAll(" ", "").length() > 2000) {
            throw new RuntimeException("limite de caracteres excedido");
        }

        entity.setLixo(false);

        // salvando anotação
        this.anotacaoRepository.save(entity);
    }

    @Override
    public void deletar(Long id) {
        // validação
        if (id == null) {
            throw new RuntimeException("O ID não pode ser nulo");
        }
        // lógica de negócio

        Optional<Anotacao> tuple = Optional.of(new Anotacao());
        // ação
        if (!tuple.isPresent()) {
            // continue a logica
        }
        else {
            throw new RuntimeException("Anotação não encontrada. Não foi possível deletar");
        }
    }

    public List<AnotacaoDtoOut> listarPorUsuario(Integer idUsuario) {

        if (idUsuario == null) {
            throw new RuntimeException("ID do usuário não pode ser nulo.");
        }

        List<Anotacao> anotacoesDoBanco = this.anotacaoRepository.findByCriadorIdUsuario(idUsuario);

        return anotacoesDoBanco.stream()
                .map(anotacao -> new AnotacaoDtoOut(anotacao))
                .collect(Collectors.toList());
    }

    @Override
    public List<Anotacao> listar() {
        // retorna todas as instâncias
        return null;
    }

    @Override
    public Anotacao buscarPorNome(String alvo) {
        // como seria essa busca?
        if(alvo.isEmpty()){
            throw new RuntimeException("o parâmetro está vazio");
        }
        Optional<Anotacao> search = Optional.of(new Anotacao());
        if(!search.isPresent()) { 
            throw new RuntimeException("não foi encontrado");

        }
        throw new RuntimeException("nada aqui");
    }

    public void moverParaLixeira(Integer idAnotacao) {

        Anotacao anotacao = this.anotacaoRepository.findById(idAnotacao)
                .orElseThrow(() -> new RuntimeException("Anotação não encontrada."));

        anotacao.setLixo(true);

        this.anotacaoRepository.save(anotacao);
    }

    public void atualizarAnotacao(Integer id, AnotacaoDtoIn dados) {
        Anotacao anotacao = this.anotacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anotação não encontrada para atualização"));

        if (dados.getCorpo() == null || (dados.getCorpo().isBlank() && dados.getTitulo().isBlank())) {
            throw new RuntimeException("Título e/ou corpo não podem ser vazios.");
        }

        anotacao.setCorpo(dados.getCorpo());
        anotacao.setTitulo(dados.getTitulo());

        this.anotacaoRepository.save(anotacao);
    }
}
