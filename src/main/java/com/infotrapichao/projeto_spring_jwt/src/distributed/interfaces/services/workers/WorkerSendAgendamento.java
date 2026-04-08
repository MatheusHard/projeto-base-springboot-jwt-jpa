package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.workers;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.common.IAgendamentoApplication;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.workers.services.AgendamentoEmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WorkerSendAgendamento {

    private final IAgendamentoApplication agendamentoApplication;
    private final AgendamentoEmailService emailService;

    public WorkerSendAgendamento(IAgendamentoApplication agendamentoApplication,
                                 AgendamentoEmailService emailService) {
        this.agendamentoApplication = agendamentoApplication;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 24 19 * * *", zone = "America/Sao_Paulo")
    public void executarTarefaDiaria() {

        System.out.println("Iniciando envio de emails...");

        AgendamentoDTO filters = new AgendamentoDTO();
        filters.setDataInicial(LocalDate.now());
        filters.setDataFinal(LocalDate.now());

        var lista = agendamentoApplication.findAllByFilter(filters);

        lista.forEach(agendamento -> {
            try {
                emailService.enviarEmailsAgendamento(agendamento);
            } catch (Exception e) {
                System.err.println("Erro ao enviar email para agendamento ID: "+ agendamento.getId());
                e.printStackTrace();
            }
        });

        System.out.println("Finalizado envio de emails.");
    }
}