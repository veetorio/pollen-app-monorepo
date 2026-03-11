package com.nectar.api.controllers;

import com.nectar.api.controllers.in.TarefaDtoIn;
import com.nectar.api.controllers.out.TarefaDtoOut; // <<< Import
import com.nectar.api.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin("*")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    public void criar(@RequestBody TarefaDtoIn dados) {
        service.criar(dados);
    }

    @GetMapping
    public List<TarefaDtoOut> listar(@RequestParam Integer idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    @PutMapping
    public void atualizar(@RequestParam Integer id, @RequestBody TarefaDtoIn dados) {
        service.atualizar(id, dados);
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id) {
        service.deletar(id);
    }
}
