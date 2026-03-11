package com.nectar.api.models.anotacoes;

import com.nectar.api.models.Usuario;
import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_anotacao;
    @Column(length = 30)
    private String  titulo;
    @Column(columnDefinition = "TEXT")
    private String corpo;

    private Boolean lixo;

    @ManyToOne
    private Usuario criador;

    public Integer getId_anotacao() {
        return id_anotacao;
    }

    public void setId_anotacao(Integer id_anotacao) {
        this.id_anotacao = id_anotacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Boolean getLixo() {
        return lixo;
    }

    public void setLixo(Boolean lixo) {
        this.lixo = lixo;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }
}
