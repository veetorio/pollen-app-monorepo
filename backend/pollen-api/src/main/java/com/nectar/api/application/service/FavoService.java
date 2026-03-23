package com.nectar.api.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nectar.api.application.repositorys.ColmeiaRepository;
import com.nectar.api.application.repositorys.FavoRepository;
import com.nectar.api.application.service.usecases.ServiceBaseCases;
import com.nectar.api.controller.in.FavoDtoIn;
import com.nectar.api.controller.out.workspace.FavoOutput;
import com.nectar.api.domain.models.Colmeia;
import com.nectar.api.domain.models.Favo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoService implements ServiceBaseCases<Favo> {

    @Autowired
    private FavoRepository repository;

    @Autowired
    private ColmeiaRepository colmeiaRepository;

    public void criar(FavoDtoIn dados) {

        Colmeia colmeiaPai = this.colmeiaRepository.findById(dados.getIdColmeiaPai())
                .orElseThrow(() -> new RuntimeException("Colmeia pai não encontrada!"));

        if (dados.getTitulo() == null || dados.getTitulo().isBlank() ||
                dados.getDescricao() == null || dados.getDescricao().isBlank()) {
            throw new RuntimeException("Título e descrição são obrigatórios.");
        }

        Favo novoFavo = new Favo();
        novoFavo.setTitulo(dados.getTitulo());
        novoFavo.setDescricao(dados.getDescricao());
        novoFavo.setColmeiaPai(colmeiaPai);

        this.salvar(novoFavo);
    }

    @Override
    public void salvar(Favo entity) {

        if (entity.getTitulo() == null || entity.getTitulo().isBlank() ||
                entity.getDescricao() == null || entity.getDescricao().isBlank()) {
            throw new RuntimeException("Título e descrição não podem ser vazios.");
        }

        if (entity.getColmeiaPai() == null) {
            throw new RuntimeException("Favo deve pertencer a uma Colmeia.");
        }

        repository.save(entity);
    }

    @Override
    public void deletar(Long id) {

        Integer idFavo = id.intValue();

        if (!repository.existsById(idFavo)) {
            throw new RuntimeException("Favo não encontrado para exclusão.");
        }

        repository.deleteById(idFavo);
    }


    @Override
    public List<Favo> listar() {
        return repository.findAll();
    }

    public List<FavoOutput> listarTodos() {
        return repository.findAll().stream()
                .map(FavoOutput::new)
                .collect(Collectors.toList());
        // (Seria necessário importar 'FavoDtoOut' e 'java.util.stream.Collectors')
    }

    @Override
    public Favo buscarPorNome(String alvo) {
        if(alvo == null || alvo.isEmpty()){ // Validação de entrada
            throw new RuntimeException("o parâmetro de busca está vazio");
        }

        // Corrigido para buscar pelo campo 'titulo'
        Optional<Favo> target = repository.findByTitulo(alvo);

        if(!target.isPresent()){
            throw new RuntimeException("Favo não foi encontrado");
        }
        return target.get();
    }

}
