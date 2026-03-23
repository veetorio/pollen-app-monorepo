package com.nectar.api.controller.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String getMethodName() {
        return "API ESTÁ FUNCIONANDO! PVF NÃO BAGUNCE";
    }
    
@GetMapping("/debug")
   public void debug() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(auth.getAuthorities());
   }
}
