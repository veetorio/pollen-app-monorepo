package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.LembreteService;
import com.nectar.api.controller.in.LembreteDtoIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lembretes")
@CrossOrigin("*")
public class LembreteController {

    @Autowired
    private LembreteService service;

    @PostMapping
    public void criar(@RequestBody LembreteDtoIn dados) {
        service.criar(dados);
    }

    //@GetMapping
    //public List<LembreteOutput> listar(@RequestParam Integer idUsuario) {
     //   return service.listarPorUsuario(idUsuario);
    //}

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Integer id, @RequestBody LembreteDtoIn dados) {
        service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}
