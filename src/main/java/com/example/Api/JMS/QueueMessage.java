package com.example.Api.JMS;

import lombok.Data;

@Data
public class QueueMessage {

    private Long seqNo;
    private String pathConfigId;
    private String messageType;
    private Object messageBody;

}

/*
public class QueueMessage {
    private Long seqNo;
    private String pathConfigId;
    private String messageType;
    private Object messageBody;
}*/
