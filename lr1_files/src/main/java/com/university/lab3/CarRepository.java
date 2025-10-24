package com.university.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс-репозиторий для хранения и управления коллекцией автомобилей.
 * Отрефакторено: добавлены методы безопасного доступа и комментарии.
 */
public class CarRepository {
    private final List<Car> cars = new ArrayList<>();

    /** Добавление нового автомобиля в репозиторий */
    public void addCar(Car car) {
        cars.add(car);
    }

    /** Удаление автомобиля из репозитория */
    public void removeCar(Car car) {
        cars.remove(car);
    }

    /** Обновление автомобиля по индексу */
    public void updateCar(int index, Car newCar) {
        if (index >= 0 && index < cars.size()) {
            cars.set(index, newCar);
        }
    }

    /** Получение списка всех автомобилей (в виде неизменяемого списка) */
    public List<Car> getAllCars() {
        return Collections.unmodifiableList(cars);
    }
}
