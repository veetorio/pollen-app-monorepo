package com.nectar.api.application.service.Facades;

import org.springframework.beans.factory.annotation.Autowired;

import com.nectar.api.application.repositorys.TarefaRepository;
import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.domain.models.Usuario;

public class AdicionarTarefaEmUsuario {
    @Autowired
    private UsuarioRepository repU;
    @Autowired
    private TarefaRepository repR;
    public static Usuario adicionarTarefaEmUsuario(){
        return null;
    }
}
