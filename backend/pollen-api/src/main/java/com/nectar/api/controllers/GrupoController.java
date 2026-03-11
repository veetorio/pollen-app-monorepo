package com.nectar.api.controllers;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.print.URIException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.nectar.api.controllers.in.GrupoDtoIn;
import com.nectar.api.controllers.out.GrupoDtoOut;
import com.nectar.api.models.Grupo;
import com.nectar.api.service.GrupoService;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@RestController
@RequestMapping("/grupos")
@CrossOrigin("*")
public class GrupoController {

    @Autowired
    private GrupoService service;


    @PostMapping
    public void criar(@RequestBody GrupoDtoIn dados) {
        service.criar(dados);
    }
    @GetMapping("toConnect")
    public URI gerarLink(@RequestParam Long grupo) {
        return service.gerarLinkDeConexao(grupo);
    }
    
    @GetMapping("conectar")
    public void conectarAoGrupo(@RequestParam UUID chave, @RequestParam Long usuario) {
        service.conectarAoGrupo(usuario,chave);
    }
    
    @GetMapping
    public List<GrupoDtoOut> listarTodos() {
        List<Grupo> gruposDoBanco = this.service.listarTodos();

        return gruposDoBanco.stream()
                .map(GrupoDtoOut::new)
                .collect(Collectors.toList());
    }

}