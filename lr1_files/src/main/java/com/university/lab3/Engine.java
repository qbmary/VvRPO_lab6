package com.university.lab3;

/**
 * Класс, описывающий двигатель автомобиля.
 */
public class Engine {
    private final int power; // мощность
    private final String manufacturer; // производитель

    public Engine(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    public int getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Двигатель: " + power + " л.с., производитель: " + manufacturer;
    }
}
