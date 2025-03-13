package com.infotrapichao.projeto_spring_jwt.junit;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;

public class Methods {

    public void ValidPassword(User user){
        var pass = "1234";
        if(!pass.equals(user.getPassword())){
            throw  new IllegalArgumentException("Senha inválida!!!");
        }
    }
}
