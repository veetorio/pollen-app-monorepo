package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.DepartamentoService;
import com.nectar.api.controller.in.DepartamentoDtoIn;
import com.nectar.api.controller.out.empresarial.DepartamentoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoOutput> salvar(@RequestBody DepartamentoDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }
}