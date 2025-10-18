package com.university.lab5;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Простое консольное приложение для демонстрации работы TernarySearch.
 * Читает массив и значение из консоли или использует пример по умолчанию.
 */
public class App {
    public static void main(String[] args) {
        // try-with-resources автоматически закроет Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Демонстрация троичного поиска. Нажми Enter, чтобы использовать пример, или введи 'custom'.");

            String line = sc.nextLine().trim();
            int[] arr;
            if ("custom".equalsIgnoreCase(line)) {
                System.out.println("Введи отсортированные числа через пробел:");
                String nums = sc.nextLine();
                String[] parts = nums.trim().split("\\s+");
                arr = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    arr[i] = Integer.parseInt(parts[i]);
                }
            } else {
                arr = new int[]{1, 2, 3, 5, 8, 13, 21, 34, 55, 89}; // пример
                System.out.println("Использую примерный массив: " + Arrays.toString(arr));
            }

            System.out.println("Введите искомое целое число:");
            int target = Integer.parseInt(sc.nextLine().trim());

            int idx = TernarySearch.ternarySearch(arr, target);
            if (idx >= 0) {
                System.out.printf("Найдено: индекс = %d, значение = %d%n", idx, arr[idx]);
            } else {
                System.out.println("Элемент не найден (возвращено -1).");
            }
        } // Scanner автоматически закрыт здесь
    }
}
