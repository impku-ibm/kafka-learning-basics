package com.ril.kafkalearning.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic pankajLearning(){
        return TopicBuilder.name("javaguide").build();
    }

    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name("jsontopic").build();
    }
}
