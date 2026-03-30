package com.nectar.api.controller.controllers.empresarial;

import com.nectar.api.application.service.EmpresaService;
import com.nectar.api.controller.in.EmpresaDtoIn;
import com.nectar.api.controller.out.empresarial.EmpresaOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private EmpresaService service;


    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<EmpresaOutput> salvar(@RequestBody EmpresaDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody EmpresaDtoIn dtoIn) {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}