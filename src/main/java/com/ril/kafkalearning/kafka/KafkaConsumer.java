package com.ril.kafkalearning.kafka;

import com.ril.kafkalearning.entity.Users;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "jsontopic",groupId="myGroup")
    //This annoation will help us to listen from topic
    public void consumeMessage(Users msg){
        System.out.println("Message received:-  " + msg.toString());
    }

    @KafkaListener(topics = "javaguide",groupId="myGroup")
    //This annoation will help us to listen from topic
    public void consumeMessage2(String msg){
        System.out.println("Message received:-  " + msg);
    }
}
