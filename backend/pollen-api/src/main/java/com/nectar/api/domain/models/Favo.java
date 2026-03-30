package com.nectar.api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

}
