package com.nectar.api.controller.controllers.empresarial;

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

import org.springframework.security.access.prepost.PreAuthorize;


@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private EquipeService service;



    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<EquipeOutput> salvar(@RequestBody EquipeDtoIn dtoIn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody EquipeDtoIn dtoIn) {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }


    
}