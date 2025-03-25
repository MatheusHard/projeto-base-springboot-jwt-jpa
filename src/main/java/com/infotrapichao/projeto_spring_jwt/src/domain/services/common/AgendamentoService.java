package com.infotrapichao.projeto_spring_jwt.src.domain.services.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common.IAgendamentoService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common.AgendamentoRepository;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoService implements IAgendamentoService {

    private final AgendamentoRepository _agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository){
        this._agendamentoRepository = agendamentoRepository;
    }

    @Override
    public Agendamento findById(Integer id) {
        return _agendamentoRepository.findById(id).orElseThrow();
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        return _agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento update(Agendamento agendamento) {
        return _agendamentoRepository.save(agendamento);
    }

    @Override
    public List<Agendamento> findAll() {
        return _agendamentoRepository.findAll();
    }
}
