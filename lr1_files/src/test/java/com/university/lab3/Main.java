package com.university.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Демонстрация работы классов Car, Driver и Engine.
 */
public class Main {
    public static void main(String[] args) {
        Driver d1 = new Driver("Иван Иванов", 3);
        Driver d2 = new Driver("Петр Петров", 10);
        Driver d3 = new Driver("Сергей Сергеев", 6);

        Engine e1 = new Engine(100, "Завод СССР");
        Engine e2 = new Engine(150, "Ford");
        Engine e3 = new Engine(120, "Завод СССР");

        Car c1 = new Car("Москвич", "С", 1200, d1, e1);
        Car c2 = new Car("Ford Focus", "B", 1400, d2, e2);
        Car c3 = new Car("Жигули", "C", 1300, d3, e3);

        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        System.out.println("Водители со стажем более 5 лет:");
        for (Car car : cars) {
            if (car.getDriver().getDrivingExperience() > 5) {
                System.out.println(car.getDriver());
            }
        }

        System.out.println("\nАвтомобили советского производства:");
        for (Car car : cars) {
            if (car.getEngine().getManufacturer().toLowerCase().contains("ссср")) {
                System.out.println(car);
            }
        }
    }
}
