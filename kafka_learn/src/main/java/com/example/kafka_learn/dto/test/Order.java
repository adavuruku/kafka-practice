package com.example.kafka_learn.dto.test;

/**
 * Created by Sherif.Abdulraheem 14/08/2024 - 01:07
 **/
public class Order {

    private final String customerName;
    private final Address deliveryAddress;

    private Order(String customerName, Address deliveryAddress) {
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public static class OrderBuilder {
        private String customerName;
        private Address deliveryAddress;

        OrderBuilder(){};

        public OrderBuilder customerName(String name) {
            this.customerName = name;
            return this;
        }

        public OrderBuilder deliveryAddress(Address address) {
            this.deliveryAddress = address;
            return this;
        }

        public Order build() {
            return new Order(customerName, deliveryAddress);
        }
    }
}
