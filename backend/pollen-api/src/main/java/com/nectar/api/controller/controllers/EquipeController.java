package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.EquipeService;
import com.nectar.api.controller.in.EquipeDtoIn;
import com.nectar.api.controller.out.empresarial.EquipeOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipes")
@RequiredArgsConstructor
public class EquipeController {

    private final EquipeService service;

    @PostMapping
    public ResponseEntity<EquipeOutput> salvar(@RequestBody EquipeDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }
}