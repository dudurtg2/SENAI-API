package com.exemplo.meuapp.infrastructure.config;

import org.springframework.context.annotation.Configuration;

/**
 * Configuração básica do OpenAPI/Swagger para documentação da API SENAI
 * 
 * O SpringDoc OpenAPI funciona automaticamente com Spring Boot 3+
 * Apenas as configurações no application.yml são suficientes para funcionamento básico
 * 
 * @author Time SENAI
 * @version 1.0
 */
@Configuration
public class SwaggerConfig {
    
    // SpringDoc OpenAPI 3 funciona automaticamente com Spring Boot
    // As configurações estão no application.yml:
    // - springdoc.api-docs.path=/api-docs
    // - springdoc.swagger-ui.path=/swagger-ui.html
    
    // Endpoints disponíveis após inicializar a aplicação:
    // http://localhost:8080/swagger-ui.html - Interface do Swagger
    // http://localhost:8080/api-docs - Documentação OpenAPI em JSON
    // http://localhost:8080/api-docs.yaml - Documentação OpenAPI em YAML
}
