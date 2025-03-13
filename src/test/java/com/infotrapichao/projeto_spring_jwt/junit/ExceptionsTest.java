package com.infotrapichao.projeto_spring_jwt.junit;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionsTest {

    @Test
    void validPassword(){
        User user = new User();
        user.setPassword("1234");
        Methods validPass = new Methods();
        assertDoesNotThrow(()-> validPass.ValidPassword(user));

    }
}
