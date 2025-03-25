package com.infotrapichao.projeto_spring_jwt.src.application.services.common;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.common.IAgendamentoApplication;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common.IAgendamentoService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoApplication implements IAgendamentoApplication {

    private final IAgendamentoService _agendamentoService;

    public AgendamentoApplication(IAgendamentoService agendamentoService){
        this._agendamentoService = agendamentoService;
    }

    @Override
    public Agendamento findById(Integer id) {
        return _agendamentoService.findById(id);
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        return _agendamentoService.create(agendamento);
    }

    @Override
    public Agendamento update(Agendamento agendamento) {
        return _agendamentoService.update(agendamento);
    }

    @Override
    public List<Agendamento> findAll() {
        return _agendamentoService.findAll();
    }
}
