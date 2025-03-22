package com.infotrapichao.projeto_spring_jwt.src.domain.services.security;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.security.IUserService;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService implements IUserService {

    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository){
        this._userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder cripty;

    @Override
    public User findById(Integer id) {
        return _userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User createUser(User user){

        if(user.getId() != null && _userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("Usuário já cadastrado!!!");
        }else{
            String pass = user.getPassword();
            //cript
            user.setPassword(cripty.encode(pass));
            return _userRepository.save(user);
        }
    }

    @Override
    public User updateUser(User user) {

        if(!_userRepository.existsById(user.getId())){
            throw new IllegalArgumentException("Usuário não cadastrado!!!");
        }else{
             return _userRepository.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return _userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return _userRepository.findByUsername(username);
    }

}
