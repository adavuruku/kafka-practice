package com.example.kafka_learn.dto.test;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Sherif.Abdulraheem 14/08/2024 - 00:37
 **/
@Getter
@Setter
@EqualsAndHashCode
public class Person {
    private int id;
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    // ... other fields ...

    // This map determines which fields to include in equals/hashCode
    private Set<String> fieldsToInclude;

    public Person() {
//        this.fieldsToInclude = fieldsToInclude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;

        for (String fieldName : fieldsToInclude) {
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object thisValue = field.get(this);
                Object otherValue = field.get(person);
                if (!Objects.equals(thisValue, otherValue)) {
                    return false;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (String fieldName : fieldsToInclude) {
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(this);
                result = 31 * result + (value != null ? value.hashCode() : 0);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> fieldsToInclude1 = new HashSet<>(List.of("name", "age", "address"));
        Person p1 = new Person();
        p1.setId(1);
        p1.setName("John Doe");
        p1.setAge(30);
        p1.setAddress("123 Street");
        p1.setFieldsToInclude(fieldsToInclude1);

        Set<String> fieldsToInclude2 = new HashSet<>(List.of("name", "age", "address"));
        Person p2 = new Person();
        p2.setId(1);
        p2.setName("John Doe");
        p2.setAge(30);
        p2.setAddress("45 Street");
        p2.setFieldsToInclude(fieldsToInclude2);

        // This will compare only based on name and age, so it should return true
        System.out.println(p1.equals(p2)); // true

        // Compare with different fields included
//        p1.setFieldsToInclude(fieldsToInclude2);
//        p2.setFieldsToInclude(fieldsToInclude1);
//        System.out.println(p1.equals(p2)); // false (because p2's address field is included)
    }
}
