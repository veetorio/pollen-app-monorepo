package com.nectar.api.controller.in;

import java.util.UUID;

import lombok.Getter;
@Getter
public class WorkSpaceInput {
    private String nome;
    private UUID publicKeyUsuario;
}
