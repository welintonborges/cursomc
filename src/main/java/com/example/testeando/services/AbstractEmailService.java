package com.example.testeando.services;

import com.example.testeando.domain.Pedido;
import org.apache.logging.log4j.message.SimpleMessage;

public abstract class AbstractEmailService  implements EmailService{

    @Override
    public void sendOrderConfirmationEmail(Pedido obj) {
        SimpleMessage sm = prepareSimpleMessageForPedido(obj);
        sendEmail(sm);
    }

    private SimpleMessage prepareSimpleMessageForPedido(Pedido obj) {
        return  null;
    }
}
