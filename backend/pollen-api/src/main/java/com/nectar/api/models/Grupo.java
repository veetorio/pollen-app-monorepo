package com.nectar.api.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grupo {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idGrupo;
    private String nomeDoGrupo;
    private LocalDate dataCriacao;
    private LocalDate dataAtualizao;

    @ManyToOne
    private Usuario criador;

    @ManyToMany
    List<Usuario> membros;
}
