package com.example.Api.JMS;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.Message;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.Destination;

@Slf4j
public class ActiveMQReceiver {

   @JmsListener(destination = "USER_IN")
    public void onMessage(ActiveMQTextMessage msg) {


        try{
            Thread.sleep(10000);
            log.info(""+msg.getText());
            msg.acknowledge();
            //QueueMessage objectMessage = (QueueMessage) message;

            //do additional processing
            //log.info("Received Message: "+ objectMessage.toString());
        } catch(Exception e) {
            log.error("Received Exception : "+ e);
        }

    }
}
