package dev.byte_forge.project001.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import dev.byte_forge.project001.user.User;
import dev.byte_forge.project001.user.UserService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class EmailVerificationService {

    private final JavaMailSender javaMailSender;
    private final UserService userService;

    public EmailVerificationService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    @RabbitListener(queues = "user-verification-queue")
    public void handleVerificationMessage(String email) {
        User user = this.userService.getByEmail(email).get();
        this.sendVerificationEmail(user);
    }

    public void sendVerificationEmail(User user) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Verify your email");
            message.setText("Click the link to verify your account: " + "http://localhost:8080/users/verify?token=" + user.getVerificationToken());
            message.setFrom("noreply@byteforge.com");

            this.javaMailSender.send(message);

        } catch(RuntimeException runtimeException) {
            runtimeException.printStackTrace();
        }
    }

}
