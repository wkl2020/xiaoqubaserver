package com.jun.xiaoquren.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("simpleJMSSender")
public class SimpleJMSSender {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleJMSSender.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void sendMessage(final String message) {
		
		for (int i = 0; i < 10; i++) {  
            jmsTemplate.send(new MessageCreator() {  
                public Message createMessage(Session session) throws JMSException {  
                    TextMessage msg = session.createTextMessage();  
                    // 设置消息属性  
                    msg.setStringProperty("phrCode", "C001");  
                    // 设置消息内容  
                    msg.setText(message);  
                    return msg;  
                }  
            });  
        }
		
	}
}
