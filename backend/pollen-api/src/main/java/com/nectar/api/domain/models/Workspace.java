package com.nectar.api.domain.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.anotacoes.Anotacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPrivate;

    @UuidGenerator
    private UUID idPublic;

    private String nome;

    @OneToMany(mappedBy = "workspace")
    private List<Anotacao> anotacoes;

    @ManyToOne
    private Usuario criador;
}
