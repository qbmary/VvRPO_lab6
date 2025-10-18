package com.university.lab3;

/**
 * Класс, описывающий водителя.
 */
public class Driver {
    private final String fullName;
    private final int drivingExperience; // стаж вождения (в годах)

    public Driver(String fullName, int drivingExperience) {
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
        return fullName + " (стаж: " + drivingExperience + " лет)";
    }
}
