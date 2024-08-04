package com.example.kafkaexample;

import com.example.kafkaexample.dto.Course;
import com.example.kafkaexample.dto.Student;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "multiGroup", topics = "multitype")
public class MultiTypeKafkaListener {

    @KafkaHandler
    public void handleCourse(Course course) {
        System.out.println("Course received: " + course.toString());
    }

    @KafkaHandler
    public void handleStudent(Student student) {
        System.out.println("Student received: "+student.toString());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
