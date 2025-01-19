package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    String descricao = "Documentação da API de Exemplo usando Springdoc OpenAPI.\n Show de Bola!!!";
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Exemplo")
                        .version("1.0")
                        .description(descricao));
    }
}

