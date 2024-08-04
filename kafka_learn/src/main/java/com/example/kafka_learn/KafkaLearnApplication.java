package com.example.kafka_learn;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaLearnApplication.class, args);
	}

	@Bean
	NewTopic testTopic() {
		return new NewTopic("${spring.kafka.json.default-topic}", 2, (short) 2);
	}
}
