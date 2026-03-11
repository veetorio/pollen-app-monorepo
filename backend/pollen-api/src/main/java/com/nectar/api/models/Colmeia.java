package com.nectar.api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Colmeia {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer idColmeia;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @CreationTimestamp
    private Instant dataCriacao;
    @UpdateTimestamp
    private Instant dataAtualizacao;
    @ManyToOne
    private Usuario criadorDaColmeia;
    @OneToMany(mappedBy = "colmeiaPai")
    private List<Favo> favos;
    public Integer getIdColmeia() {
        return idColmeia;
    }
    public void setIdColmeia(Integer idColmeia) {
        this.idColmeia = idColmeia;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public Usuario getCriadorDaColmeia() {
        return criadorDaColmeia;
    }
    public void setCriadorDaColmeia(Usuario criadorDaColmeia) {
        this.criadorDaColmeia = criadorDaColmeia;
    }
    public List<Favo> getFavos() {
        return favos;
    }
    public void setFavos(List<Favo> favos) {
        this.favos = favos;
    }
    
}
