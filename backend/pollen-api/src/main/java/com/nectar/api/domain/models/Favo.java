package com.nectar.api.domain.models;

import jakarta.persistence.*;

@Entity
public class Favo {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer idFavo;

    @Column(length = 30)
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @ManyToOne
    private Colmeia colmeiaPai;
    public Integer getIdFavo() {
        return idFavo;
    }
    public void setIdFavo(Integer idFavo) {
        this.idFavo = idFavo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Colmeia getColmeiaPai() {
        return colmeiaPai;
    }
    public void setColmeiaPai(Colmeia colmeiaPai) {
        this.colmeiaPai = colmeiaPai;
    }
    
}
