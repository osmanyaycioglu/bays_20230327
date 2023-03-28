package com.training.spring.bays.java;

//    MerhabaOsman  --> Pascal
//    merhabaOsman  --> Camel
//    merhaba-osman --> kebap
//    merhaba_osman --> Snake
public class Car {

    private int    avgSpeed;
    private String name;

    public Car() {
        super();
    }

    public Car(final int avgSpeedParam,
               final String nameParam) {
        super();
        this.avgSpeed = avgSpeedParam;
        this.name = nameParam;
    }

    public double forward(final int kms) {
        return kms / this.avgSpeed;
    }

    public int getAvgSpeed() {
        return this.avgSpeed;
    }

    public void setAvgSpeed(final int avgSpeedParam) {
        this.avgSpeed = avgSpeedParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

}
