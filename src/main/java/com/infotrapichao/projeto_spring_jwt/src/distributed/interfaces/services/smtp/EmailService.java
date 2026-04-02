package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.services.smtp;

import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.EmailDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.helpers.Utils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendHtmlEmail(EmailDTO emailDTO) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(emailDTO.getDestinatario());
            helper.setSubject(emailDTO.getAssunto());
            helper.setText(getCorpo(emailDTO), true); // true = habilita HTML
            helper.setFrom(emailDTO.getRemetente());

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            System.out.println("Erro ao enviar e-mail: " + e.getMessage());
        }
    }

    private String getCorpo(EmailDTO emailDTO) {
        String nomeUser = emailDTO.getNomeUsuario();
        String descricao = emailDTO.getDescricao();
        String valor = emailDTO.getValor().toString();
        String dataVencimento = Utils.getDataFormatada(emailDTO.getVencimento(), false);

        return String.format("""
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="UTF-8">
            </head>
            <body style="font-family: Arial, sans-serif; font-size: 16px; color: #000;">
              <br>
                  <p>Olá <strong>Sr.(a) %s</strong>,</p>
                  <p>Segue abaixo os detalhes da sua fatura:</p>
                  <p>📄 Fatura: <strong style="font-size: 18px;">%s</strong></p>
                  <p>💰 Valor: R$ %s</p>
                  <p>📅 Vencimento: %s</p>
              <br>
                  <p>Por favor, verifique as informações até a data de vencimento para evitar encargos adicionais.</p>
            </body>
            </html>
            """, nomeUser, descricao, valor, dataVencimento);
    }
}