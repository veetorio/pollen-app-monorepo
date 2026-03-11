package com.nectar.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nectar.api.controllers.in.UsuarioDtoIn;
import com.nectar.api.controllers.out.UsuarioDtoOut;
import com.nectar.api.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @PostMapping
    public void cadastrar(@RequestBody UsuarioDtoIn entity) {
        service.cadastrar(entity);
    }

    @PostMapping("/login")
    public UsuarioDtoOut login(@RequestBody UsuarioDtoIn entity) {
        return service.entrar(entity.getEmail(),entity.getSenha());
    }
    @DeleteMapping
    public void deleteFisico(@RequestParam Integer param) {
        service.excluirContaPermanentemente(param);
    }

    @DeleteMapping("/desativar")
    public void deleteLogico(@RequestParam Integer param){
        service.desativarConta(param);
    } 



}
