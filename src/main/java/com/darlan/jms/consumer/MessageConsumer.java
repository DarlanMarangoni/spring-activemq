package com.darlan.jms.consumer;

import com.darlan.jms.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    private MessageProducer producer;

    @JmsListener(destination = "mailbox")
    public void receiveMessage(String email) {
        System.out.println("Received <" + email + ">");
        producer.producer(email);
    }
}
