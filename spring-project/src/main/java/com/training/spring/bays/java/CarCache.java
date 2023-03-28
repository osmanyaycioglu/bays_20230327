package com.training.spring.bays.java;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CarCache {

    public CarCache() {
        System.out.println("CarCache yaratılıyor");
    }

    private final Map<String, Car> carMap = new HashMap<>();

    public void addCar(final Car carParam) {
        this.carMap.put(carParam.getName(),
                        carParam);
    }

    public Car getCar(final String name) {
        return this.carMap.get(name);

    }

}
