package com.nectar.api.controllers;

import com.nectar.api.controllers.in.ColmeiaDtoIn;
import com.nectar.api.controllers.out.ColmeiaDtoOut;
import com.nectar.api.models.Colmeia;
import com.nectar.api.service.ColmeiaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void criar(@RequestBody ColmeiaDtoIn dados) {

        service.criar(dados);
    }

    @GetMapping
    public List<ColmeiaDtoOut> listarTodas() {

        List<Colmeia> colmeiasDoBanco = this.service.listar();

        return colmeiasDoBanco.stream()
                .map(ColmeiaDtoOut::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        this.service.deletar(id.longValue());
    }

    @PutMapping("/{id}")
    public void atualizarColmeia(@PathVariable Integer id, @RequestBody ColmeiaDtoIn dados) {

        this.service.atualizarDescricao(id, dados);
    }
}
