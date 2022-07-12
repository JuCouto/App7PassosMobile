package com.residencia.comercio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Value("${spring.mail.host}")
	private String mailHost;
	
	@Value("${spring.mail.port}")
	private String mailPort;
	
	@Value("${spring.mail.username}")
	private String mailUserName;
	
	@Value("${spring.mail.password}")
	private String mailPassword;
	
	@Autowired
	JavaMailSender emailSender;
	
	public MailService(JavaMailSender javaMailSender) {
		this.emailSender = javaMailSender;
	}
	
	public void enviarEmailTexto(String destinatarioEmail, String assunto, String mensagemEmail) {
		SimpleMailMessage sMailMessage = new SimpleMailMessage();
		
		sMailMessage.setTo(destinatarioEmail);
		sMailMessage.setSubject(assunto);
		sMailMessage.setText(mensagemEmail);
		//Cuidado no momento de usar um servidor real, para setar um remetente valido abaixo
		sMailMessage.setFrom("teste@teste.com");
		
		emailSender.send(sMailMessage);
	}
	
	public void enviarEmailHtml(String destinatarioEmail, String assunto, String mensagemEmail) {
		
	}
	
}
