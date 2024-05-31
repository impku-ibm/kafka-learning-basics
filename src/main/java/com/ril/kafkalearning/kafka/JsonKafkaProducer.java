package com.ril.kafkalearning.kafka;

import com.ril.kafkalearning.entity.Users;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private KafkaTemplate<String, Users> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Users> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUser(Users data){
        System.out.println("User object is sent :- " + data.toString());
        Message<Users> message = MessageBuilder.withPayload(data).
                setHeader(KafkaHeaders.TOPIC,"jsontopic").build();
        kafkaTemplate.send(message);
    }
}
