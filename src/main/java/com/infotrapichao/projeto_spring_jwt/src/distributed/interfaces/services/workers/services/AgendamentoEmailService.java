package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.workers.services;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.EmailDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.smtp.EmailService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoEmailService {

    @Autowired
    private EmailService emailService;

    public void enviarEmailsAgendamento(Agendamento agendamento) {

        // envia para profissional
        enviarParaProfissional(agendamento);

        // envia para cliente (se existir)
        if (agendamento.getCliente().getEmail() != null) {
            enviarParaCliente(agendamento);
        }
    }

    private void enviarParaProfissional(Agendamento agendamento) {
        EmailDTO email = buildEmail(
                agendamento.getUser().getUsername(),
                agendamento.getUser().getEmail(),
                "Novo agendamento recebido"
        );
        emailService.sendHtmlEmail(email, true);
    }

    private void enviarParaCliente(Agendamento agendamento) {
        EmailDTO email = buildEmail(
                agendamento.getCliente().getName(),
                agendamento.getCliente().getEmail(),
                "Confirmação de agendamento"
        );

        emailService.sendHtmlEmail(email, true);
    }

    private EmailDTO buildEmail(String nome, String destinatario, String assunto) {
        EmailDTO email = new EmailDTO();
        email.setNomeUsuario(nome);
        email.setDestinatario(destinatario);
        email.setAssunto(assunto);
        email.setRemetente("matheushard2013@gmail.com");
        return email;
    }
}