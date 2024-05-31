package com.ril.kafkalearning.kafka;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducer {
    private KafkaTemplate<String,String> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        System.out.println("Message sent is " + message);
        kafkaTemplate.send("javaguide",message);
    }
}
