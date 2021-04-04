package com.task2.ch2;

public class Car {
    private double x = 0;
    private double fuelVolume = 0;
    private final double fuelConsumption;

    public Car(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public boolean drive(double miles) {
        double requiredFuelVolume = miles * fuelConsumption;
        if (requiredFuelVolume > fuelVolume) return false;
        fuelVolume -= requiredFuelVolume;
        x += miles;
        return true;
    }

    public void refuel(double volume) {
        fuelVolume += volume;
    }

    public double getDistance() {
        return x;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }
}
