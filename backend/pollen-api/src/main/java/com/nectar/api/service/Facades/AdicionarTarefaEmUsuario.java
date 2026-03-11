package com.nectar.api.service.Facades;

import org.springframework.beans.factory.annotation.Autowired;

import com.nectar.api.models.Usuario;
import com.nectar.api.repositorys.TarefaRepository;
import com.nectar.api.repositorys.UsuarioRepository;

public class AdicionarTarefaEmUsuario {
    @Autowired
    private UsuarioRepository repU;
    @Autowired
    private TarefaRepository repR;
    public static Usuario adicionarTarefaEmUsuario(){
        return null;
    }
}
