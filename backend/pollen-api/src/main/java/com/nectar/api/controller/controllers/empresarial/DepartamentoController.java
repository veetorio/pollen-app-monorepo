package com.nectar.api.controller.controllers.empresarial;

import com.nectar.api.application.service.DepartamentoService;
import com.nectar.api.controller.in.DepartamentoDtoIn;
import com.nectar.api.controller.out.empresarial.DepartamentoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private DepartamentoService service;


    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<DepartamentoOutput> salvar(@RequestBody DepartamentoDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody DepartamentoDtoIn dtoIn) {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}