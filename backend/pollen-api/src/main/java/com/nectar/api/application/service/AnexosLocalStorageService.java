package com.nectar.api.application.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.management.RuntimeErrorException;

import org.springframework.web.multipart.MultipartFile;

import com.nectar.api.application.service.gateway.SalvarAnexoStrategy;
import com.nectar.api.controller.in.AnexoInput;

public class AnexosLocalStorageService implements SalvarAnexoStrategy {
    @Override
    public String salvarAnexo(MultipartFile file, AnexoInput input) { 
        Path path = Paths.get("backend/pollen-api/src/main/resources/upload/" + input.getName());
        try {
            Files.createDirectories(path);
            Files.write(path, file.getBytes());
        } catch(IOException e) {
            throw new RuntimeException("error ao salvar arquivo",e);
        }

        return path.toString();
    }
}
