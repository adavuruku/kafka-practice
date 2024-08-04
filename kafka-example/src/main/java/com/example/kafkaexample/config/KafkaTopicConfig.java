package com.example.kafkaexample.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic amigoscodeTopic(){
        return TopicBuilder.name("amigoscode")
                .build();
    }

    @Bean
    public NewTopic multitype(){
        return TopicBuilder.name("multitype")
                .build();
    }

    @Bean
    public NewTopic top1(){
        return TopicBuilder.name("top1")
                .build();
    }
}
