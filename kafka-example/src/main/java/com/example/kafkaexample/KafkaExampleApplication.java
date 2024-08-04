package com.example.kafkaexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;


//reference docs

//https://spring.io/projects/spring-kafka
//https://docs.spring.io/spring-kafka/docs/current/reference/html/
//https://www.youtube.com/watch?v=SqVfCyfCJqw
//https://stackoverflow.com/questions/48448079/json-parse-error-can-not-construct-instance-of-io-starter-topic-topic
// https://medium.com/@houssemmedine.drissi/class-vs-record-difference-between-class-and-record-in-java-75d7ea6da145#:~:text=Records%20are%20immutable%20data%20classes,immutable%2C%20while%20classes%20are%20not.
//https://www.conduktor.io/kafka/how-to-start-kafka-using-docker/
// watch tom https://www.youtube.com/watch?v=rjDUpxtUPAE

@SpringBootApplication
public class KafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args->{
			for (int i = 0; i < 2; i++) {
				kafkaTemplate.send("amigoscode", "Hello Kafka ### " + i);
			}

		};
	}
}
