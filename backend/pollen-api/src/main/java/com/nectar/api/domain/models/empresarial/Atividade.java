package com.nectar.api.domain.models.empresarial;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Atividade {

	private String head;

	private String content;
    
    @ManyToOne
    private Equipe equipe;

    @Size(min = 0 , max = 5)
	private List<String> anexos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long idPrivate;

    @UuidGenerator
	private UUID idPublic;

}