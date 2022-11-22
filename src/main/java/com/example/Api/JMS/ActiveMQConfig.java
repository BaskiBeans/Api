package com.example.Api.JMS;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.Arrays;


@Configuration
public class ActiveMQConfig {

@Value("${activemq.broker-url}")
private String brokerUrl;

private String CONCURRENCY = "2-2";

@Bean
public ActiveMQConnectionFactory senderActiveMQConnectionFactory(){
    ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
    activeMQConnectionFactory.setBrokerURL(brokerUrl);

    return activeMQConnectionFactory;
}
@Bean
public CachingConnectionFactory cachingConnectionFactory(){
    return new CachingConnectionFactory(senderActiveMQConnectionFactory());
}

@Bean
public JmsTemplate jmsTemplate(){
    return new JmsTemplate(cachingConnectionFactory());
}

@Bean
public ActiveMQSender sender(){
    return new ActiveMQSender();
}


//TODO

@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(senderActiveMQConnectionFactory());
    factory.setConcurrency(CONCURRENCY);
    factory.setSessionAcknowledgeMode(ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);

    return factory;
}

@Bean
public ActiveMQReceiver receiver(){
    return  new ActiveMQReceiver();
}


    /*
@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency(CONCURRENCY);
    factory.setSessionAcknowledgeMode(ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
    return factory;
}

    @Bean
    public ActiveMQReceiver receiver() {
        return new ActiveMQReceiver();
    }

    @Bean
    public ResponseFileActiveMQReceiver receiveJs() {
        return new ResponseFileActiveMQReceiver();
    }

     */

}
