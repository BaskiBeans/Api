package com.example.Api.JMS;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Slf4j
@Component
public class ActiveMQSender {

    @Autowired
   private JmsTemplate jmsTemplate;

    private long DELAY_TIME = 10 * 1000;

    public void send(String queue, String message){
        //jmsTemplate.convertAndSend(queue,message);
        //ajmsTemplate.convertAndSend(queue,message);

        jmsTemplate.convertAndSend(queue, message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                log.info("postProcessMessage executed");
                message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, DELAY_TIME);
                log.info("long time" + message.getLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY));
                return message;
            }
        });
        log.info("Sending done " + message + " at " + System.currentTimeMillis());
    }

    //public void send(String queue, Object object){
    //    jmsTemplate.convertAndSend(queue,object);
   // }
}


/*
public class ActiveMQSender {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String queue, String message) {
		jmsTemplate.convertAndSend(queue, message);
	}

	public void send(String queue, Object object) {
		jmsTemplate.convertAndSend(queue, object);
	}

}
 */