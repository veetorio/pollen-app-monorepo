package com.nectar.api.models;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.nectar.api.models.anotacoes.Anotacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUsuario;

    @Column(length = 50,unique = true)
    private String nome;
    @Column(length = 40,unique = true)
    private String email;
    @Column(length = 50)
    private String senha; // acabei de adicionar
    @Column
    private Boolean atividade = true;

    @CreationTimestamp
    private Instant dataCriacao;

    @UpdateTimestamp
    private Instant  dataAtualizacao;

    @OneToMany(mappedBy = "criador")
    List<Anotacao> anotacoes;
    @OneToMany(mappedBy = "criadorDaColmeia")
    List<Colmeia> colmeias;
    // List<Grupo> grupos;

 
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtividade() {
        return atividade;
    }

    public void setAtividade(Boolean atividade) {
        this.atividade = atividade;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<Colmeia> getColmeias() {
        return colmeias;
    }

    public void setColmeias(List<Colmeia> colmeias) {
        this.colmeias = colmeias;
    }
}
