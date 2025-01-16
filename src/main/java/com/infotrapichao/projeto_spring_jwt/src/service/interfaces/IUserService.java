package com.infotrapichao.projeto_spring_jwt.src.service.interfaces;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;

import java.util.List;

public interface IUserService {

    User findById(Integer id);
    User createUser(User user);
    List<User> findAll();
}
