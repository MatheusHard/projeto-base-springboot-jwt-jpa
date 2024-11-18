package com.infotrapichao.projeto_spring_jwt.src.service;

import com.infotrapichao.projeto_spring_jwt.src.models.User;
import com.infotrapichao.projeto_spring_jwt.src.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder cripty;

    public void createUser(User user){
        String pass = user.getPassword();
        //cript
        user.setPassword(cripty.encode(pass));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
