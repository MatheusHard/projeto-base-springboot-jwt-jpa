package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private List<String> roles;

}
