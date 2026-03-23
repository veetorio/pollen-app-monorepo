/**
 * The `GrupoService` class in a Java Spring application provides methods for creating, updating,
 * listing, and deleting groups, with validations for group names and user existence.
 */
package com.nectar.api.application.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.nectar.api.application.repositorys.UsuarioRepository;
import com.nectar.api.application.service.mappers.UsuarioMapper;
import com.nectar.api.controller.in.UsuarioInput;
import com.nectar.api.controller.out.ContribuidorOutput;
import com.nectar.api.controller.out.TokenOutput;
import com.nectar.api.controller.out.UsuarioOutput;
import com.nectar.api.domain.models.Usuario;
import com.nectar.api.domain.models.anotacoes.Anotacao;
import com.nectar.api.utils.RoleUsuario;

import ch.qos.logback.core.subst.Token;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    UsuarioMapper usMapper;

    @Autowired
    JwtEncoder jwtEncoder;

    public void cadastrar(UsuarioInput usuario){
        // validações básicas
        if(usuario == null) {
            throw new RuntimeException("E-mail obrigatório para o cadastro");
        }

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
        this.repository.save(usMapper.usuarioInputInUsuario(usuario));
    }

    public UsuarioOutput entrar(String email,String senha) {
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

        RoleUsuario role = usuarioDoBanco.getTipo();

        UsuarioOutput usuarioOutput = usMapper.usuarioInContribuidor(usuarioDoBanco);

        Instant now = Instant.now();
        Instant expiry = now.plusSeconds(3600);

        var claims = JwtClaimsSet.builder()
            .issuer("pollen-api")
            .issuedAt(now)
            .expiresAt(expiry)
            .claim("scope",usuarioDoBanco.getTipo())
            .claim("nome",usuarioDoBanco.getNome())
            .subject(usuarioOutput.getIdPublic().toString())
            .build();

        var jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        if(role == RoleUsuario.CONTRIBUIDOR){
            usuarioOutput = usMapper.usuarioInContribuidor(usuarioDoBanco);
        }
        if(role == RoleUsuario.ADMIN){
            usuarioOutput = usMapper.usuarioInAdmin(usuarioDoBanco);
        }

        TokenOutput token = new TokenOutput();

        token.setToken(jwt);
        token.setExpiresIn(expiry);
        usuarioOutput.setAuthToken(token);

        return usuarioOutput;
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



}



