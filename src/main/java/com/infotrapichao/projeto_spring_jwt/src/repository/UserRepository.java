package com.infotrapichao.projeto_spring_jwt.src.repository;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    //Query Method
    //List<User> findByNameContaining(String name);

    //Query Method
    User findByUsername(String username);

    //Query Override
    @Query("SELECT u FROM User u JOIN FETCH u.roles WHERE u.username= (:username)")
    List<User> findByUserName(@Param("username") String username);

    boolean existsByUsername(String username);
}
