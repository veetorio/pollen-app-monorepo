package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.AnotacaoService;
import com.nectar.api.controller.in.AnotacaoDtoIn;
import com.nectar.api.controller.out.workspace.AnotacaoOutput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anotacoes")
@CrossOrigin("*")
public class AnotacaoController {

    @Autowired
    private AnotacaoService service;

    @PostMapping
    public void criar(@RequestBody AnotacaoDtoIn dados) {

        service.criar(dados);
    }


    @GetMapping
    public List<AnotacaoOutput> listar() {
        return null;
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id, @RequestBody AnotacaoDtoIn dados) {
        // método vazio
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        // método vazio
    }

}
