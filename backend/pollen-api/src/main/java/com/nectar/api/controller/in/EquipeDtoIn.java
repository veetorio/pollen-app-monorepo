package com.nectar.api.controller.in;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EquipeDtoIn {
    private String nome;
    private UUID departamentoIdPublic; // O Departamento pai
    private List<UUID> contribuidoresIds; // Lista de UUIDs dos usuários membros
}
