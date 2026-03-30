package com.nectar.api.controller.in;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.nectar.api.utils.TypeArchive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnexoInput {
    private UUID idAtividade;
    private String name;
    private TypeArchive tipo;
}
