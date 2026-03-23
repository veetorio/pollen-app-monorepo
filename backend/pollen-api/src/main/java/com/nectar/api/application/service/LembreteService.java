package com.nectar.api.application.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nectar.api.application.repositorys.LembreteRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.controller.in.LembreteDtoIn;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.anotacoes.Lembrete;

@Service
public class LembreteService {

    @Autowired
    private LembreteRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criar(LembreteDtoIn dados) {

        Usuario criador = usuarioRepository.findById(dados.getIdCriador())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (dados.getDataInicio() == null) {
            throw new RuntimeException("Lembrete precisa de uma data de início.");
        }

        if(dados.getTitulo() == null || dados.getTitulo().isBlank()){
            throw new RuntimeException("Sem título do lembrete");
        }

        if(dados.getTitulo().length() > 40 || dados.getCorpo().length() > 255) {
            throw new RuntimeException("Excedeu tamanho máximo (40 para título, 255 para corpo).");
        }

        Lembrete novoLembrete = new Lembrete();
        novoLembrete.setTitulo(dados.getTitulo());
        novoLembrete.setCorpo(dados.getCorpo());
        novoLembrete.setLixo(false);
        novoLembrete.setDataInicio(dados.getDataInicio());
        novoLembrete.setDataTermino(dados.getDataTermino());

        repository.save(novoLembrete);
    }

  
    public void deletar(Integer id) {
        // Valida se existe no BANCO DE DADOS, não na memória
        if (!repository.existsById(id)) {
            throw new RuntimeException("Lembrete não encontrado.");
        }
        repository.deleteById(id);
    }

    public static int calcularDiasRestantes(LocalDate start, LocalDate end) {
        return (int) ChronoUnit.DAYS.between(start, end);
    }

    public void atualizar(Integer id, LembreteDtoIn dados) {
        Lembrete lembrete = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado para atualização."));

        if (dados.getTitulo() != null && !dados.getTitulo().isBlank()) {

            lembrete.setTitulo(dados.getTitulo());
        }

        if (dados.getCorpo() != null) {
            lembrete.setCorpo(dados.getCorpo());
        }

        if (dados.getDataInicio() != null) {
            lembrete.setDataInicio(dados.getDataInicio());
        }

        if (dados.getDataTermino() != null) {
            lembrete.setDataTermino(dados.getDataTermino());
        }

        repository.save(lembrete);
    }

}