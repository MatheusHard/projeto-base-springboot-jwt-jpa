package com.infotrapichao.projeto_spring_jwt.src.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/users").permitAll()
                        .requestMatchers(SWAGGER_WHITELIST).permitAll()
                        //.requestMatchers("/public/**").permitAll() // Rotas públicas
                        //.requestMatchers(HttpMethod.POST, "/users").permitAll()// Rota User
                        //.requestMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS")
                        //.requestMatchers("/managers").hasAnyRole("MANAGERS")
                        .anyRequest().authenticated() // Qualquer outra rota exige autenticação
                )
                .logout(LogoutConfigurer::permitAll
                );

        return http.build();
    }

}
