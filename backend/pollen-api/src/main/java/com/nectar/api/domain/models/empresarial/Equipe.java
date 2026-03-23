package com.nectar.api.domain.models.empresarial;


import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipe {

	private String nome;

    @ManyToOne
    private Departamento departamento;

    @ManyToMany
    private List<Usuario> contribuidores;

    @OneToMany(mappedBy = "equipe")
    private List<Atividade> atividades;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPrivate;

    @UuidGenerator
	private UUID idPublic;

}