package com.example.kafka_learn.hack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by Sherif.Abdulraheem 30/10/2024 - 22:40
 **/
public class Gen <T>{
    public T getValue() {
        return value;
    }

    public Gen(T value) {
        this.value = value;
    }

    private T value;

    public static void main(String[] args) {
        ArrayList<Gen> gens = new ArrayList<>();
        Gen<?> g1 = new Gen<>(10);
        Gen<?> g2 = new Gen<>("hek");
        gens.add(g1);
        gens.add(g2);
//        int i = gens.get(0).getValue();
//        String s = gens.get(1).getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime now = LocalDateTime.now();
        String str = now.format(formatter);
        System.out.println(str);
        LocalDateTime formattedDateTime = LocalDateTime.parse("2024-10-31T13:57:27.815572", formatter);

        System.out.println(formattedDateTime);
    }
}
