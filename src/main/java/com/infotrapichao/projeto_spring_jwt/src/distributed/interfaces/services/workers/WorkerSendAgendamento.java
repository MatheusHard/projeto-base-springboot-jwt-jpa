package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.workers;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.common.IAgendamentoApplication;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.AgendamentoDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.EmailDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.smtp.EmailService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WorkerSendAgendamento {

    private final IAgendamentoApplication _agendamentoApplication;
    @Autowired
    private EmailService emailService;
    public WorkerSendAgendamento(IAgendamentoApplication agendamentoApplication) { _agendamentoApplication = agendamentoApplication;}

    @Scheduled(cron = "0 24 19 * * *", zone = "America/Sao_Paulo") // 1º segundos; 2º minutos; 3º horas [Campo]
    public void executarTarefaDiaria() {
        System.out.println("Executando tarefa diária às 16:35...");
        this.execSendEmails();
        System.out.println("Fim tarefa diária...");
    }

    private void execSendEmails() {
        AgendamentoDTO filters = new AgendamentoDTO();
        filters.setDataInicial(LocalDate.now()); //Pegar apenas faturas que vencem hoje
        filters.setDataFinal(LocalDate.now());
        //filters.se;
        var list = _agendamentoApplication.findAllByFilter(filters);
        for (Agendamento agendamento : list) {
            sendEmail(agendamento, true);
            if(agendamento.getCliente().getEmail() != null) sendEmail(agendamento, false);
        }
    }

    private void sendEmail(Agendamento agendamento, boolean toUser){
        emailService.sendHtmlEmail(this.generateEmailDTO(agendamento, toUser), true);
    }
    private EmailDTO generateEmailDTO(Agendamento agendamento, boolean toUser){
        EmailDTO email = new EmailDTO();
        email.setNomeUsuario(toUser ? agendamento.getUser().getUsername() : agendamento.getCliente().getName());
        email.setAssunto("Atendimento");
        email.setDestinatario(toUser ? agendamento.getUser().getEmail() :  agendamento.getCliente().getEmail());
        email.setRemetente("matheushard2013@gmail.com");

        return email;
    }
}
