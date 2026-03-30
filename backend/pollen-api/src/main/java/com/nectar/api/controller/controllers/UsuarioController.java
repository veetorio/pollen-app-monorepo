package com.nectar.api.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nectar.api.application.service.UsuarioService;
import com.nectar.api.controller.in.UsuarioInput;
import com.nectar.api.controller.in.UsuarioLogin;
import com.nectar.api.controller.out.UsuarioOutput;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    UsuarioService service;

    @PostMapping
    @PreAuthorize("permitAll()") 
    public void cadastrar(@RequestBody UsuarioInput entity) {
        service.cadastrar(entity);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')") 
    public void atualizar(@RequestBody UsuarioInput entity) {
        service.atualizar(entity);
    }

    @PostMapping("/login")
    public UsuarioOutput login(@RequestBody UsuarioLogin entity) {
        return service.entrar(entity.getEmail(),entity.getSenha());
    }
    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void deleteFisico(@RequestParam Integer param) {
        service.excluirContaPermanentemente(param);
    }

    @DeleteMapping("/desativar")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public void deleteLogico(@RequestParam Integer param){
        service.desativarConta(param);
    } 



}
