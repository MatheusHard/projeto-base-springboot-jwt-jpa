package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.security;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
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
