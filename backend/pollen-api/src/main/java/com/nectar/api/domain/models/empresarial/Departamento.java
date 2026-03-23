package com.nectar.api.domain.models.empresarial;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

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
public class Departamento {

	private String nome;

	private String Setor;

    @ManyToOne
    private Empresa empresa;

    @OneToMany(mappedBy = "departamento")
    private List<Equipe> equipes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idPrivate;

    @UuidGenerator
	private UUID idPublic;

}