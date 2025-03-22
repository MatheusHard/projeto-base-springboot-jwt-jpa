package com.infotrapichao.projeto_spring_jwt.src.application.services.security;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.security.IUserApplication;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.security.IUserService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserApplication implements IUserApplication {


    private final IUserService _userService;

    public UserApplication(IUserService userService){
        this._userService = userService;
    }
    @Override
    public User findById(Integer id) {
        return _userService.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return _userService.findByUsername(username);
    }

    @Override
    public User createUser(User user) {
        return _userService.createUser(user);
    }

    @Override
    public User updateUser(User user){ return _userService.updateUser(user);}

    @Override
    public List<User> findAll() {
        return _userService.findAll();
    }
}
