package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.controllers.security;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.security.IUserApplication;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security.LoginDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security.SessionDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.jwt.JwtService;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.configuration.jwt.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private JwtService jwtService;

    private final IUserApplication _userApplication;

    public AuthController(IUserApplication userApplication){
        this._userApplication = userApplication;
    }

    @PostMapping("/login")
    public SessionDTO login(@RequestBody LoginDTO login) {

        User user = _userApplication.findByUsername(login.getUsername());

        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login" + login.getUsername());
            }
            //Estamos enviado o token
            SessionDTO session = new SessionDTO();
            session.setLogin(user.getUsername());
            // Definindo claims adicionais
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", user.getRoles()); // Adiciona as roles do usuário ao token
            claims.put("organization", "Infotrapichao/SA"); // Exemplo de outro claim personalizado

            String token = jwtService.generateToken(user.getUsername(), claims);

            session.setToken(token);
            user.setPassword(null);
            session.setUser(user);

            return session;
        } else {
            throw new RuntimeException("Erro ao fazer login");
        }
    }

    }
