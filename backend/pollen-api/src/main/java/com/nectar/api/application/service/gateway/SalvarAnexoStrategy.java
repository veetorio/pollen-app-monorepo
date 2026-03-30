package com.nectar.api.application.service.gateway;

import java.io.FileInputStream;

import org.springframework.web.multipart.MultipartFile;

import com.nectar.api.controller.in.AnexoInput;

public interface SalvarAnexoStrategy {
   public String salvarAnexo(MultipartFile file, AnexoInput input);
}
