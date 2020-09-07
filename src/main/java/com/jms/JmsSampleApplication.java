package com.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class JmsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsSampleApplication.class, args) ;

	}

	/*
	JmsMessage - types are either TextMessage or BytesMessage
	This Message Converter uses Jackson 2.x to convert messages to and from JSON.
	Maps an object to a BytesMessage
	otherwise to TextMessage if MessageType.TEXT
	 */
	/*@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		//This property needs to set inorder to allow for the
		//incoming messages to a Java Object.
		converter.setTypeIdPropertyName("_type");
		return converter;
	}*/

}
