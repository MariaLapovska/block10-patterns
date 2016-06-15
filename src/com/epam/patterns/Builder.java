package com.epam.patterns;

/**
 * Builder pattern
 */
public class Builder {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildModel("Mercedes")
                .buildTransmission(Transmission.MANUAL)
                .buildMaxSpeed(280)
                .build();

        System.out.println(car);
    }
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    String model;
    Transmission transmission;
    int maxSpeed;

    public void setModel(String model) {
        this.model = model;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder{
    String model = "default";
    Transmission transmission = Transmission.AUTO;
    int s = 120;

    CarBuilder buildModel(String model) {
        this.model = model;
        return this;
    }

    CarBuilder buildTransmission (Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildMaxSpeed (int s) {
        this.s = s;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setModel(model);
        car.setTransmission(transmission);
        car.setMaxSpeed(s);
        return car;
    }
}
