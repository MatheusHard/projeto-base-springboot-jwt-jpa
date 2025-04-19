package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.webconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Mapeia URL "/uploads/**" para a pasta real "uploads/" no sistema de arquivos
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/") // Pasta onde suas imagens são salvas
                .setCachePeriod(3600); // cache opcional
    }
}

