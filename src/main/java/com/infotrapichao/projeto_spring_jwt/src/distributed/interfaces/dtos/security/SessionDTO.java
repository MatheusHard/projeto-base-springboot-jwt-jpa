package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SessionDTO {

    private String login;
    private String token;
    private User user;

    }
