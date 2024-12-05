package com.infotrapichao.projeto_spring_jwt.src.controller;


import com.infotrapichao.projeto_spring_jwt.src.models.User;
import com.infotrapichao.projeto_spring_jwt.src.repository.UserRepository;
import com.infotrapichao.projeto_spring_jwt.src.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void postUser(@Validated  @RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping()
    public void put(@RequestBody User usuario){
        userRepository.save(usuario);
    }
    @GetMapping()
    public List<User> getAll(){
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getOne(@PathVariable("id") Integer id){
        return userRepository.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

}
