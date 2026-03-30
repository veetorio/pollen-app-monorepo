package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.AtividadeService;
import com.nectar.api.application.service.EquipeService;
import com.nectar.api.controller.in.AnexoInput;
import com.nectar.api.controller.in.EquipeDtoIn;
import com.nectar.api.controller.out.empresarial.EquipeOutput;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService service;


    @PostMapping
    public ResponseEntity<EquipeOutput> salvar(@RequestBody EquipeDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }


    
}