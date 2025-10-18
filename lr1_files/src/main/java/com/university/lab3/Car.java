package com.university.lab3;

/**
 * Класс, описывающий автомобиль.
 */
public class Car {
    private final String brand;
    private final String carClass;
    private final double weight;
    private final Driver driver;   // композиция
    private final Engine engine;   // композиция

    public Car(String brand, String carClass, double weight, Driver driver, Engine engine) {
        this.brand = brand;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarClass() {
        return carClass;
    }

    public double getWeight() {
        return weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return brand + " [" + carClass + "], вес: " + weight + " кг, " + engine + ", водитель: " + driver;
    }
}
