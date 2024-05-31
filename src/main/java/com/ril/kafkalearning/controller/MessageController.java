package com.ril.kafkalearning.controller;

import com.ril.kafkalearning.entity.Users;
import com.ril.kafkalearning.kafka.JsonKafkaProducer;
import com.ril.kafkalearning.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
   @Autowired
private KafkaProducer kafkaProducer;

@Autowired
private JsonKafkaProducer jkp;

    public MessageController(JsonKafkaProducer jkp,KafkaProducer kafkaProducer) {
        this.jkp = jkp;
        this.kafkaProducer=kafkaProducer;
    }

    //http:localhost:8080/api/v1/kafka/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
kafkaProducer.sendMessage(message);
return ResponseEntity.ok("Message sent to the topic");
    }

    @PostMapping("/pushdata")
    public ResponseEntity<String> publishMessage(@RequestBody Users data){
       jkp.sendUser(data);
       return ResponseEntity.ok("Message sent");
    }
}
