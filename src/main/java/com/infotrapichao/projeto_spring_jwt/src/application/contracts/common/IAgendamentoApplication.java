package com.infotrapichao.projeto_spring_jwt.src.application.contracts.common;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.ClienteDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;

import java.util.List;

public interface IAgendamentoApplication {
    Agendamento findById(Integer id);
    Agendamento create(Agendamento agendamento);
    Agendamento update(Agendamento agendamento);
    List<Agendamento> findAll();
    List<Agendamento> findAllByFilter(AgendamentoDTO filter);
}
