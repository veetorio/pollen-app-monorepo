package com.nectar.api.controllers;

import com.nectar.api.controllers.in.FavoDtoIn;
import com.nectar.api.controllers.out.FavoDtoOut;
import com.nectar.api.models.Favo;
import com.nectar.api.service.FavoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favos")
@CrossOrigin("*")
public class FavoController {

    @Autowired
    private FavoService service;

    @PostMapping
    public void criar(@RequestBody FavoDtoIn dados) {
        service.criar(dados);
    }

    @GetMapping
    public List<FavoDtoOut> listar() {

        List<Favo> favosDoBanco = this.service.listar();

        return favosDoBanco.stream()
                .map(FavoDtoOut::new)
                .collect(java.util.stream.Collectors.toList());
    }

    @GetMapping("/busca")
    public FavoDtoOut buscar(@RequestParam String alvo) {

        Favo favoEncontrado = this.service.buscarPorNome(alvo);

        return new FavoDtoOut(favoEncontrado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        // Conversão de Integer para Long é obrigatória para a interface do Service.
        this.service.deletar(id.longValue());
    }

}
