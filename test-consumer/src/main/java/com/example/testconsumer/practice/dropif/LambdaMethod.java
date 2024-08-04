package com.example.testconsumer.practice.dropif;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LambdaMethod {
    private Map<String, Function<Double, Double>> discountsStrategies = new HashMap<>();

    LambdaMethod(){
        discountsStrategies.put("SUMMER_SALE", price -> price * 0.9);
        discountsStrategies.put("WINTER_SALE", price -> price * 0.4);
        discountsStrategies.put("RAINY_SALE", price -> price * 0.7);
    }

    public double applyDiscount(String discountType, double price){
        return discountsStrategies.getOrDefault(discountType, Function.identity()).apply(price);
    }
}
