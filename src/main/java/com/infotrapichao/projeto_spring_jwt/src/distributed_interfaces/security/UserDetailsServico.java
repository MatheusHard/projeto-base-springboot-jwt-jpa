package com.infotrapichao.projeto_spring_jwt.src.distributed_interfaces.security;


import com.infotrapichao.projeto_spring_jwt.src.application.contracts.security.IUserApplication;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServico implements UserDetailsService {

    private final IUserApplication _userApplication;

    @Autowired
    public UserDetailsServico(IUserApplication userApplication) {
        this._userApplication = userApplication;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = _userApplication.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getAuthorities()
        );
    }
}