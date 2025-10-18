package com.university.lab3;

import java.util.ArrayList;
import java.util.List;

/**
 * Главный класс приложения для демонстрации работы иерархии классов.
 */
public class App {
    public static void main(String[] args) {
        // Создание водителей
        Driver driver1 = new Driver("Иван Иванов", 6);
        Driver driver2 = new Driver("Петр Петров", 3);
        Driver driver3 = new Driver("Мария Сидорова", 10);

        // Создание двигателей
        Engine engine1 = new Engine(120, "Toyota");
        Engine engine2 = new Engine(80, "ЗАЗ");
        Engine engine3 = new Engine(150, "BMW");

        // Создание автомобилей
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota Corolla", "B", 1300.0, driver1, engine1));
        cars.add(new Car("ЗАЗ 965", "A", 700.0, driver2, engine2));
        cars.add(new Car("BMW X5", "E", 2200.0, driver3, engine3));

        // Все автомобили
        System.out.println("Все автомобили:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Водители со стажем более 5 лет
        System.out.println("\nВодители со стажем более 5 лет:");
        for (Car car : cars) {
            if (car.getDriver().getDrivingExperience() > 5) {
                System.out.println(car.getDriver());
            }
        }

        // Автомобили советского производства
        System.out.println("\nАвтомобили советского производства:");
        for (Car car : cars) {
            if (car.getBrand().toLowerCase().contains("заз") ||
                car.getEngine().getManufacturer().toLowerCase().contains("заз") ||
                car.getBrand().toLowerCase().contains("ваз") ||
                car.getBrand().toLowerCase().contains("лада")) {
                System.out.println(car);
            }
        }
    }
}
