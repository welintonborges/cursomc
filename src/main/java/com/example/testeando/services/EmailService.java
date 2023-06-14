package com.example.testeando.services;

import com.example.testeando.domain.Pedido;
import org.apache.logging.log4j.message.SimpleMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMessage msg);

}
