package com.nectar.api.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Pollen API sistema organizacional pessoal e empresarial",
                version = "1.0.0",
                description = "API REST para gerenciamentos de tarefas e lembretes de forma eficiente e com auxilio de IA para novas ideias",
                contact = @Contact(
                        name = "Ettore Vitorio",
                        email = "contato@exemplo.com"
                )
        
        )
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class DocumentationConfig {
}
