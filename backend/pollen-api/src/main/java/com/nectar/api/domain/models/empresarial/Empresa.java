package com.nectar.api.domain.models.empresarial;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.Usuario;

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
public class Empresa {
    private String nome;

	private int cnpj;

    @ManyToOne
    private Usuario manager;

    @OneToMany(mappedBy = "empresa")
    private List<Departamento> departamentos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idPrivate;

    @UuidGenerator
	private UUID idPublic;
}
