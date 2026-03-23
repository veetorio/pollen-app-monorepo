package com.nectar.api.controller.out;

import java.time.Instant;

import com.nimbusds.jwt.JWT;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenOutput {
    private String token;
    private Instant expiresIn;
}
