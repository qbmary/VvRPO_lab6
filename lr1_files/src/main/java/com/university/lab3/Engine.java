package com.university.lab3;

/**
 * Класс, описывающий двигатель автомобиля.
 * Отрефакторено: добавлен equals() и hashCode() для корректного сравнения объектов.
 */
public class Engine {
    private final int power;          // мощность
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
        return String.format("Двигатель: %d л.с., производитель: %s", power, manufacturer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Engine)) return false;
        Engine e = (Engine) obj;
        return power == e.power && manufacturer.equalsIgnoreCase(e.manufacturer);
    }

    @Override
    public int hashCode() {
        return manufacturer.toLowerCase().hashCode() + power;
    }
}
