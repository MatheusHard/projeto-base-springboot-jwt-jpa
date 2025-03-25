package com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
}
