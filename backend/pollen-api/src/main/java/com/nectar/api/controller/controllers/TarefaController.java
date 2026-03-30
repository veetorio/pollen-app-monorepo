package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.TarefaService;
import com.nectar.api.controller.in.TarefaDtoIn;
import com.nectar.api.controller.out.TarefaOutput; // <<< Import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("*")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void criar(@RequestBody TarefaDtoIn dados) {
        service.criar(dados);
    }


    @PutMapping
    public void atualizar(@RequestParam Integer id, @RequestBody TarefaDtoIn dados) {
        service.atualizar(id, dados);
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id) {
        service.deletar(id);
    }

    @GetMapping
    public List<TarefaOutput> listar() {
        return null;
    }
}
