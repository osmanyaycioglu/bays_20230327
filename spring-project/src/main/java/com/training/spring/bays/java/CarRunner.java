package com.training.spring.bays.java;

public class CarRunner {

    public static void main(final String[] args) {
        Car xyz = new Car(100,
                          "BMW 520i");
        double forwardLoc = xyz.forward(200);
        int a = 100;
        Integer ao = 100;

        float f = 1.2F;
        Float fo = 1.2F;

        Double doubleLoc = 100D;
        String stringLoc = "sdkjfhskdfh";
        System.out.println("Süre (saat) : " + forwardLoc);
    }

}
