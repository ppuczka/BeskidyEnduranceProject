package pl.coderslab.beskidyenduranceproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.coderslab.beskidyenduranceproject.entity.User;

import javax.mail.internet.MimeMessage;

@Service
public class EmailSerivice {

    private JavaMailSender sender;

    @Autowired
    public EmailSerivice(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail(User user) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(user.getEmail());
        helper.setText("Witaj właśnie zarejestrowałeś się w Beskidy Endurance");
        helper.setSubject("Beksidy Endurance potwierdzenie rejestracji");

        sender.send(message);
    }
}
