package com.example.testconsumer.practice.dropif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentService {
    Map<String, PaymentStrategy> paymentStrategyList = new HashMap<>();
    PaymentService(List<PaymentStrategy> strategyList){
        for(PaymentStrategy paymentStrategy: strategyList){
            paymentStrategyList.put(paymentStrategy.getClass().getSimpleName(), paymentStrategy);
        }
    }

    public void processPayment(String strategyName, double amount){
        PaymentStrategy paymentStrategy = paymentStrategyList.get(strategyName);
        if(paymentStrategy != null){
            paymentStrategy.pay(amount);
        }else{
            throw new IllegalArgumentException("No such payment strategy "+ paymentStrategy);
        }
    }
}
