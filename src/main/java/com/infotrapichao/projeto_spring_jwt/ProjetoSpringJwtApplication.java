package com.infotrapichao.projeto_spring_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjetoSpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringJwtApplication.class, args);
	}

}
