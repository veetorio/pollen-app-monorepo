package com.nectar.api.controller.in;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArquivoInput {
    private MultipartFile anexo;
    private String name;
}
