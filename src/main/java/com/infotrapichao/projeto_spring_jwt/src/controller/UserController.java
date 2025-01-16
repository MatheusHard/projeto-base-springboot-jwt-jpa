package com.infotrapichao.projeto_spring_jwt.src.controller;


import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.repository.UserRepository;
import com.infotrapichao.projeto_spring_jwt.src.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService){
        this._userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@Validated  @RequestBody User user){
        var userCreated = _userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

   /* @PutMapping()
    public void put(@RequestBody User usuario){
        userRepository.save(usuario);
    }*/
    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(_userService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id){
        var user = _userService.findById(id);
        return ResponseEntity.ok(user);
    }
    /*
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }*/

}
