package com.example.testconsumer.practice.dropif;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+ amount + "using paypal.");
    }
}
