package com.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @JmsListener(destination = "mailbox")
    public void receiveEmail(Email email) {
        System.out.println("Received email  "+ email);
    }

}
