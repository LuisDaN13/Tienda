package com.Tienda.tienda.service.impl;

import com.Tienda.tienda.service.CorreoService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoServiceImpl implements CorreoService {

    @Autowired //Libreria de mandar correos
    private JavaMailSender mailSender;

    @Override //variables para to, subject, content
    public void enviarCorreoHtml(
            String para,
            String asunto,
            String contenidoHtml)
            throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage(); //aqui crea mensaje tipo MimeMessage
        MimeMessageHelper helper = new MimeMessageHelper(message, true); //Se encarga de setear datos
        helper.setTo(para);                             //aqui declara que el "To" es la variable "para" que habiamos creado
        helper.setSubject(asunto);                   //aqui declara que el "Subject" es la variable "asunto" que habiamos creado
        helper.setText(contenidoHtml, true);       //aqui declara que el "To" es la variable "para" que habiamos creado, y el true es para que sepa que es HTML
        mailSender.send(message);                 //ahora si manda el mensaje
    }
}
