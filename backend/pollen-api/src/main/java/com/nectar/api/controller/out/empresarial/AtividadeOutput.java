package com.nectar.api.controller.out.empresarial;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AtividadeOutput {
	private UUID idPublic;
	private String head;
	private String content;
	private List<String> anexos;
}