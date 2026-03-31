package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;


public class SessionDTO {

    public SessionDTO(){}

    private String login;
    private String token;
    private User user;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
