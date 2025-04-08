package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findAll(Specification<Agendamento> agendamentoSpecification);

}
