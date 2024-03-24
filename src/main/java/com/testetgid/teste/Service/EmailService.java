package com.testetgid.teste.Service;

import java.math.BigDecimal;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String emailDestination, String cnpj, String method, BigDecimal value) {
        var message = new SimpleMailMessage();
        message.setFrom("joaovitordlg23101@outlook.com");
        message.setTo(emailDestination);
        message.setSubject("Transação");
        message.setText(String.format("Transação de %s concluída. CNPJ da empresa: %s valor da transação: R$" + value  + "", method, cnpj));
        javaMailSender.send(message);
    }

}
