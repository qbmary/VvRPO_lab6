package com.university.lab3;

import java.util.List;

/**
 * Демонстрация работы классов Car, Driver, Engine и CarRepository.
 * Отрефакторено: логика фильтрации вынесена в отдельные методы для читаемости.
 */
public class Main {
    public static void main(String[] args) {
        CarRepository repo = new CarRepository();

        repo.add(new Car("Москвич", "C", 1200, new Driver("Иван Иванов", 3), new Engine(100, "Завод СССР")));
        repo.add(new Car("Ford Focus", "B", 1400, new Driver("Петр Петров", 10), new Engine(150, "Ford")));
        repo.add(new Car("Жигули", "C", 1300, new Driver("Сергей Сергеев", 6), new Engine(120, "Завод СССР")));

        printExperiencedDrivers(repo.getAll());
        printSovietCars(repo.getAll());
    }

    /** Вывод водителей со стажем более 5 лет */
    private static void printExperiencedDrivers(List<Car> cars) {
        System.out.println("Водители со стажем более 5 лет:");
        cars.stream()
            .map(Car::getDriver)
            .filter(driver -> driver.getDrivingExperience() > 5)
            .forEach(System.out::println);
    }

    /** Вывод автомобилей советского производства */
    private static void printSovietCars(List<Car> cars) {
        System.out.println("\nАвтомобили советского производства:");
        cars.stream()
            .filter(car -> car.getEngine().getManufacturer().toLowerCase().contains("ссср"))
            .forEach(System.out::println);
    }
}
