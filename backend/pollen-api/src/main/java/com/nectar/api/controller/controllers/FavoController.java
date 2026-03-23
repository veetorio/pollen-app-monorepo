package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.FavoService;
import com.nectar.api.controller.in.FavoDtoIn;
import com.nectar.api.controller.out.workspace.FavoOutput;
import com.nectar.api.domain.models.Favo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favos")
@CrossOrigin("*")
public class FavoController {

    @Autowired
    private FavoService service;

    @PostMapping
    public void criar(@RequestBody FavoDtoIn dados) {
        service.criar(dados);
    }

    @GetMapping
    public List<FavoOutput> listar() {

        List<Favo> favosDoBanco = this.service.listar();

        return favosDoBanco.stream()
                .map(FavoOutput::new)
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/busca")
    public FavoOutput buscar(@RequestParam String alvo) {

        Favo favoEncontrado = this.service.buscarPorNome(alvo);

        return new FavoOutput(favoEncontrado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        // Conversão de Integer para Long é obrigatória para a interface do Service.
        this.service.deletar(id.longValue());
    }

}
