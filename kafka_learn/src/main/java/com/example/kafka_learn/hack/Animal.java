package com.example.kafka_learn.hack;

/**
 * Created by Sherif.Abdulraheem 30/10/2024 - 22:31
 **/
public interface Animal {
    default void speak() {
        System.out.println("fff");
    }

    void eat();
}
