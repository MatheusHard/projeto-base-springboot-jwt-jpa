package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.controllers.security;


import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security.UserDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers.UserMapper;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.domain.services.security.UserService;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.security.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService _userService;

    public UserController(UserService userService){
        this._userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@Validated  @RequestBody UserDTO userDTO){

        User usuario = UserMapper.toUser(userDTO);
        var userCreated = _userService.createUser(usuario);
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
    public ResponseEntity<List<UserDTO>> findAll(){
        var lista = UserMapper.toUserDTOList(_userService.findAll());
        return ResponseEntity.ok(lista);
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
