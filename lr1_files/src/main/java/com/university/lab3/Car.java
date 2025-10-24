package com.university.lab3;

/**
 * Класс, описывающий автомобиль.
 * Включает марку, класс, массу, а также объекты водителя и двигателя (композиция).
 * Отрефакторено: добавлены комментарии и улучшено форматирование вывода.
 */
public class Car {
    private final String brand;      // марка автомобиля
    private final String carClass;   // класс автомобиля
    private final double weight;     // масса
    private final Driver driver;     // композиция
    private final Engine engine;     // композиция

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
        return String.format("%s [%s], вес: %.1f кг, %s, водитель: %s",
                brand, carClass, weight, engine, driver);
    }
}
