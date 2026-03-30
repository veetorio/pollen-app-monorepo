package com.nectar.api.controller.controllers.empresarial;

import com.nectar.api.application.service.AtividadeService;
import com.nectar.api.controller.in.AnexoInput;
import com.nectar.api.controller.in.AtividadeDtoIn;
import com.nectar.api.controller.out.empresarial.AtividadeOutput;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService service;


    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<AtividadeOutput> salvar(@RequestBody AtividadeDtoIn dtoIn) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dtoIn));
    }

    @PostMapping(path = "/anexo",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<Void> salvarAnexo(@RequestPart("file") MultipartFile file, @RequestPart("entity") String entity) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        AnexoInput input = mapper.readValue(entity, AnexoInput.class);
        return ResponseEntity.ok().body(service.salvarAnexo(file, input));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody AtividadeDtoIn dtoIn) {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}
