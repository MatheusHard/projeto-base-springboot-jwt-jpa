package com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;

import java.util.List;

public interface IAgendamentoService {
    Agendamento findById(Integer id);
    Agendamento create(Agendamento agendamento);
    Agendamento update(Agendamento agendamento);
    List<Agendamento> findAll();
}
