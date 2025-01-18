package com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.controllers;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.security.IUserApplication;
import com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.dtos.Login;
import com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.dtos.Session;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.security.JwtService;
import com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private JwtService jwtService;

    private final IUserApplication _userApplication;

    public LoginController(IUserApplication userApplication){
        this._userApplication = userApplication;
    }
    //@Autowired
    //private UserRepository userRepository;


   /*PostMapping("/login")
    public Session login(@RequestBody Login login){
        User user = userRepository.findByUsername(login.getUsername());

        if(user != null){
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if(!passwordOk){
                throw new RuntimeException("Senha inválida para o login"+ login.getUsername());
            }
            //Estamos enviado o token
            Session session = new Session();
            session.setLogin(user.getUserName());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssueAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration(new Date(System.currentTimeMillis() + securityConfig.getEXPIRATION()));
            jwtObject.setRoles(user.getRoles());
            session.setToken(JWTCreator.create(securityConfig.getPREFIX(), securityConfig.getKEY(), jwtObject));

            return session;
        }else{
            throw new RuntimeException("Erro ao fazer login");
        }
    }*/

    @PostMapping("/login")
    public Session login(@RequestBody Login login) {
        User user = _userApplication.findByUsername(login.getUsername());

        if (user != null) {
            boolean passwordOk = encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login" + login.getUsername());
            }
            //Estamos enviado o token
            Session session = new Session();
            session.setLogin(user.getUserName());
            // Definindo claims adicionais
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", user.getRoles()); // Adiciona as roles do usuário ao token
            claims.put("organization", "Infotrapichao/SA"); // Exemplo de outro claim personalizado

            String token = jwtService.generateToken(user.getUserName(), claims);

            session.setToken(token);

            return session;
        } else {
            throw new RuntimeException("Erro ao fazer login");
        }
    }

    }
