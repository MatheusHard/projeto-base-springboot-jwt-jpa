package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;

import java.util.List;

public class AgendamentoMapper {

    public static AgendamentoDTO toAgendamentoDTO(Agendamento agendamento) {
        return new AgendamentoDTO(agendamento.getId(), agendamento.getCreatedAt(), agendamento.getUpdatedAt(),
                                  agendamento.isFinalizado(), agendamento.getUser(), agendamento.getCliente(),
                                  agendamento.getObservacao(), agendamento.isDeletado());
    }

    public static Agendamento toAgendamento(AgendamentoDTO agendamentoDTO) {
        return new Agendamento(agendamentoDTO.getId(), agendamentoDTO.getCreatedAt(), agendamentoDTO.getUpdatedAt(),
                               agendamentoDTO.isFinalizado(), agendamentoDTO.getUser(), agendamentoDTO.getCliente(),
                               agendamentoDTO.getObservacao(), agendamentoDTO.isDeletado());
    }

    public static List<AgendamentoDTO> toAgendamentoDTOList(List<Agendamento> agendamentos) {
        return agendamentos.stream().map(a -> {
            AgendamentoDTO dto =  AgendamentoMapper.toAgendamentoDTO(a);
            //Aqui pode mudar campo do objeto, caso queira
            dto.getUser().setClientes(null);
            dto.getUser().setPassword(null);
            return dto;
        }).toList();
    }

    public static List<Agendamento> toAgendamentoList(List<AgendamentoDTO> agendamentosDtos) {
        return agendamentosDtos.stream().map(AgendamentoMapper::toAgendamento).toList();
    }
}
