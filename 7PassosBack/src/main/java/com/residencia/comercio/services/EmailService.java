package com.residencia.comercio.services;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	public JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;

	@Value("${spring.mail.host}")
	private String emailServerHost;

	@Value("${spring.mail.port}")
	private Integer emailServerPort;

	@Value("${spring.mail.username}")
	private String emailServerUserName;

	@Value("${spring.mail.password}")
	private String emailServerPassword;
	
	@Value("${mail.from}")
	private String mailFrom;
	
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();

		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setUsername(emailServerUserName);
		mailSender.setPassword(emailServerPassword);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
		mailSender.setJavaMailProperties(prop);

		return mailSender;
	}
	
	public EmailService(JavaMailSender javaMailSender) {
        this.emailSender = javaMailSender;
    }

    public void sendTextMail(String toEmail, String subject, String message) {
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailMessage.setFrom(mailFrom);

        emailSender.send(mailMessage);
    }
    
    public void sendHtmlMail(String toEmail, String subject, String message) throws Exception {
		this.emailSender = javaMailSender();

		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		try {
			helper.setFrom(mailFrom);
			helper.setTo(toEmail);
			helper.setSubject(subject);

			StringBuilder sBuilder = new StringBuilder();
			sBuilder.append("<html>\r\n");
			sBuilder.append("	<body>\r\n");
			sBuilder.append("		<div align=\"center\">\r\n");
			sBuilder.append("			E-MAIL NO FORMATO HTML\r\n");
			sBuilder.append("		</div>\r\n");
			sBuilder.append("		<br/>\r\n");
			sBuilder.append("		<center>\r\n");
			sBuilder.append(message);
			sBuilder.append("		</center>\r\n");
			sBuilder.append("	</body>\r\n");
			sBuilder.append("</html>");

			helper.setText(sBuilder.toString(), true);

			emailSender.send(mimeMessage);

		} catch (Exception e) {
			throw new Exception("Erro ao enviar o email - " + e.getMessage());
		}
	}
}
