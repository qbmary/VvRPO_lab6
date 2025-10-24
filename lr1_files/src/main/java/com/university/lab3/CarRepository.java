package com.university.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Репозиторий для хранения и управления объектами Car.
 */
public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    /** Добавляет новую машину в коллекцию. */
    public void add(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        cars.add(car);
    }

    /** Удаляет машину из коллекции. */
    public void remove(Car car) {
        cars.remove(car);
    }

    /** Обновляет существующую машину. */
    public void update(Car oldCar, Car newCar) {
        int idx = cars.indexOf(oldCar);
        if (idx >= 0) {
            cars.set(idx, newCar);
        } else {
            throw new IllegalArgumentException("Car not found in repository");
        }
    }

    /** Возвращает все машины (в виде неизменяемого списка). */
    public List<Car> getAll() {
        return Collections.unmodifiableList(cars);
    }

    /** Удаляет все машины. */
    public void clear() {
        cars.clear();
    }

    /** Возвращает количество машин в коллекции. */
    public int size() {
        return cars.size();
    }

    @Override
    public String toString() {
        return "CarRepository{" +
                "cars=" + cars +
                '}';
    }
}
