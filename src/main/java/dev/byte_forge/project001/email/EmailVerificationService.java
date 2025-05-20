package dev.byte_forge.project001.email;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {

    public EmailVerificationService() {
    }

    @RabbitListener(queues = "user-verification-queue")
    public void handleVerificationMessage() {

    }

}
