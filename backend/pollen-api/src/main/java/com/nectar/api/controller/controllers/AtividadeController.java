package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.AtividadeService;
import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividades")
@RequiredArgsConstructor
public class AtividadeController {

    private final AtividadeService service;

    @PostMapping
    public ResponseEntity<AtividadeOutput> salvar(@RequestBody AtividadeDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }
}
