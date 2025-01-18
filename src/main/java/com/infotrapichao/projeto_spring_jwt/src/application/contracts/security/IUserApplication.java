package com.infotrapichao.projeto_spring_jwt.src.application.contracts.security;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface IUserApplication {
    User findById(Integer id);
    User findByUsername(String username);
    User createUser(User user);
    List<User> findAll();

}


