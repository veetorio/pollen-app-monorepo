/**
 * The `GrupoService` class in a Java Spring application provides methods for creating, updating,
 * listing, and deleting groups, with validations for group names and user existence.
 */
package com.nectar.api.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nectar.api.controllers.in.UsuarioDtoIn;
import com.nectar.api.controllers.out.UsuarioDtoOut;
// import com.nectar.api.models.Grupo;
import com.nectar.api.models.Usuario;
import com.nectar.api.models.anotacoes.Anotacao;
import com.nectar.api.repositorys.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public void cadastrar(UsuarioDtoIn usuario){
        // validações básicas
        if (usuario.getEmail() == null || usuario.getEmail().isBlank()) {
            throw new RuntimeException("E-mail obrigatório para o cadastro");
        }

        if (usuario.getNome() == null || usuario.getNome().isBlank()) {
            throw new RuntimeException("Nome obrigatório para cadastro");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            throw new RuntimeException("Senha obrigatória para cadastro");
        }

        // setar padrões

        Usuario tuple = new Usuario();
        tuple.setAtividade(true);
        tuple.setEmail(usuario.getEmail());
        tuple.setNome(usuario.getNome());
        tuple.setSenha(usuario.getSenha());
        this.repository.save(tuple);
    }

    public UsuarioDtoOut entrar(String email,String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);

        if (usuario.isEmpty()) {
            throw new RuntimeException("E-mail ou senha incorretos.");
        }

        Usuario usuarioDoBanco = usuario.get();

        if (!usuarioDoBanco.getAtividade()) {
            throw new RuntimeException("Esta conta está desativada");
        }

        
        if (!usuario.get().getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }

        return new UsuarioDtoOut(usuarioDoBanco);
    }

    public void excluirContaPermanentemente(Integer idUsuario) {
        Optional<Usuario> usuario = this.repository.findById(idUsuario);

        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado, não foi possível excluir.");
        }

        Usuario usuarioParaExcluir = usuario.get();

        this.repository.delete(usuarioParaExcluir);
    }

    public void desativarConta(Integer idUsuario) {
        Optional<Usuario> usuario = this.repository.findById(idUsuario);

        if (usuario.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado, não foi possível desativar.");
        }

        Usuario usuarioParaDesativar = usuario.get();

        usuarioParaDesativar.setAtividade(false);
        // data da deleção
        usuarioParaDesativar.setDataAtualizacao(Instant.now());

        // salva o estado do usuario no banco
        this.repository.save(usuarioParaDesativar);

    }

    public void criarAnotacao(Anotacao anotacao){

    }

    public List<Anotacao> anotacoes(){
        return null;
    }

    // public void criarGrupo(Grupo grupo){

    // }
    // public void entrarGrupo(){
        
    // }
}



