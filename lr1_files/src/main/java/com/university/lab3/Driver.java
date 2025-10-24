package com.university.lab3;

/**
 * Класс, описывающий водителя.
 * Отрефакторено: добавлена проверка корректности стажа.
 */
public class Driver {
    private final String fullName;        // ФИО водителя
    private final int drivingExperience;  // стаж вождения (в годах)

    public Driver(String fullName, int drivingExperience) {
        if (drivingExperience < 0)
            throw new IllegalArgumentException("Стаж не может быть отрицательным");
        this.fullName = fullName;
        this.drivingExperience = drivingExperience;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    @Override
    public String toString() {
        return String.format("%s (стаж: %d лет)", fullName, drivingExperience);
    }
}
