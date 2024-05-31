package com.ril.kafkalearning.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "javaguide",groupId="myGroup")
    //This annoation will help us to listen from topic
    public void consumeMessage(String msg){
        System.out.println("Message received:-  " + msg);
    }
}
