package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Cliente findByCpf(String cpf);
    List<Cliente> findAll(Specification<Cliente> clienteSpecification);
}
