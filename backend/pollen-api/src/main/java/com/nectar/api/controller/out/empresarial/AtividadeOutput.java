package com.nectar.api.controller.out.empresarial;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.empresarial.Equipe;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AtividadeOutput {
    private String head;

	private String content;
    
	private List<String> anexos;

	private UUID idPublic;
}