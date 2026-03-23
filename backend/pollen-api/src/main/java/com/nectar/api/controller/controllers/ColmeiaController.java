package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.ColmeiaService;
import com.nectar.api.controller.in.ColmeiaDtoIn;
import com.nectar.api.controller.out.workspace.ColmeiaOutput;
import com.nectar.api.domain.models.Colmeia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colmeias")
@CrossOrigin("*")
public class ColmeiaController {

    @Autowired
    private ColmeiaService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void criar(@RequestBody ColmeiaDtoIn dados) {

        service.criar(dados);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public List<ColmeiaOutput> listarTodas() {

        List<Colmeia> colmeiasDoBanco = this.service.listar();

        return null;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void deletar(@PathVariable Integer id) {
        this.service.deletar(id.longValue());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void atualizarColmeia(@PathVariable Integer id, @RequestBody ColmeiaDtoIn dados) {

        this.service.atualizarDescricao(id, dados);
    }
}
