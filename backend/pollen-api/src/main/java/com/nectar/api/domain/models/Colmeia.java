package com.nectar.api.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Colmeia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idColmeia;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    @CreationTimestamp
    private Instant dataCriacao;
    @UpdateTimestamp
    private Instant dataAtualizacao;
    @ManyToOne
    @JoinColumn(name = "usuario_id_private")
    private Usuario criadorDaColmeia;

    @OneToMany(mappedBy = "colmeiaPai")
    private List<Favo> favos;
}
