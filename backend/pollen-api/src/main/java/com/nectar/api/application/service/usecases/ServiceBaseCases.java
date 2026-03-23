package com.nectar.api.application.service.usecases;

import java.util.List;

public interface ServiceBaseCases<U> {
    void salvar(U entity);
    void deletar(Long id);

    List<U> listar();
    U buscarPorNome(String alvo);
}
