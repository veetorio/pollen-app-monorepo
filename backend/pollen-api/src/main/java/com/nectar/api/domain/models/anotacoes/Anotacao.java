package com.nectar.api.domain.models.anotacoes;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.Workspace;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Anotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPrivate;

    @UuidGenerator
    private UUID idPublic;

    @Column(length = 30)
    private String  titulo;
    @Column(columnDefinition = "TEXT")
    private String corpo;

    private Boolean lixo;

    @ManyToOne
    private Workspace workspace;
}
