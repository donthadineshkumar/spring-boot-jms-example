package com.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {

    @Autowired
    JmsTemplate jmsTemplate;

    /*
    Note: org.springframework.jms.support.converter.MessageConversionException:
    Cannot convert object of type [com.jms.Email] to JMS message.
    Supported message payloads are: String, byte array, Map<String,?>, Serializable object.\r\n\tat
    org.springframework.jms.support.converter.SimpleMessageConverter.toMessage
    (SimpleMessageConverter.java:79)
    at org.springframework.jms.core.JmsTemplate.lambda$convertAndSend

    To convert this Email object to JMS message, you need to Jackson Databind dependency
    This create a bean available
    MappingJackon2HttpMessageConverter -
    which can serialize message content to json using TextMessage
     */
    @GetMapping("/send")
    public String sendMessage() {
        jmsTemplate.convertAndSend("mailbox",
                new Email("receiver@gmail.com",
                        "sender@gmail.com",
                        "Confidential"));
        return "Email Sent";
    }

}
