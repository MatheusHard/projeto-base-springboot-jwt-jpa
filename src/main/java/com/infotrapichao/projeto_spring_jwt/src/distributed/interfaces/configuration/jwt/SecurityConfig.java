package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {

    private String PREFIX;
    private String KEY;
    private Long EXPIRATION;

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

    public Long getEXPIRATION() {
        return EXPIRATION;
    }

    public void setEXPIRATION(Long EXPIRATION) {
        this.EXPIRATION = EXPIRATION;
    }
}
