package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.starter;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.security.IUserApplication;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.security.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(IUserApplication userApplication, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userApplication.findByUsername("admin") == null) {
                User admin = new User();
                admin.setEmail("admin@example.com");
                admin.setUsername("admin");
                admin.setCreatedAt(LocalDateTime.now());
                admin.setPassword("123456"); // ou outro nome do campo
                var roles = List.of("MANAGERS", "USERS");
                admin.setRoles(roles);

                userApplication.createUser(admin);

                System.out.println("🟢 Usuário admin criado com sucesso!");
            }
        };
    }
}
