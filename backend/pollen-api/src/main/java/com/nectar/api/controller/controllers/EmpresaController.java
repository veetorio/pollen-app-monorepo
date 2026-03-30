package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.EmpresaService;
import com.nectar.api.controller.in.EmpresaDtoIn;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaService service;

    @PostMapping
    public ResponseEntity<EmpresaOutput> salvar(@RequestBody EmpresaDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }
}