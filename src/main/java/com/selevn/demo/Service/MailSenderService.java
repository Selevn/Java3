package com.selevn.demo.Service;

import com.selevn.demo.config.EmailConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class MailSenderService {
/*

    @Autowired
    private EmailConfig emailConfig;

    public void sendMail(String to, String subject, String text){

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(this.emailConfig.getHost());
        sender.setPort(this.emailConfig.getPort());
        sender.setUsername(this.emailConfig.getUsername());
        sender.setPassword(this.emailConfig.getPassword());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(this.emailConfig.getMail());
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        sender.send(mailMessage);
    }


*/

    private final JavaMailSender mailSender;

    @Async
    public void sendMail(String to, String subject, String message) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(message, true);
            helper.setTo(to);
            helper.setSubject("Order confirmation");
            helper.setFrom("gamesstoreforjava@gmail.com");
            mailSender.send(mimeMessage);
        } catch (MessagingException e){
            //LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }

}
