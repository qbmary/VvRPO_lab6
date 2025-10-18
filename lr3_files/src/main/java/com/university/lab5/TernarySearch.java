package com.university.lab5;

/**
 * Реализация троичного поиска (ternary search) над отсортированным массивом.
 * Переменные именованы в соответствии с твоим python-примером:
 * left, right, mid1, mid2, arr, target.
 */
public class TernarySearch {

    /**
     * Выполняет троичный поиск.
     *
     * @param arr    отсортированный по возрастанию массив int
     * @param target искомое значение
     * @return индекс найденного элемента или -1, если не найден
     */
    public static int ternarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if (arr[mid1] == target)
                return mid1;
            if (arr[mid2] == target)
                return mid2;

            if (target < arr[mid1]) {
                right = mid1 - 1;
            } else if (target > arr[mid2]) {
                left = mid2 + 1;
            } else {
                left = mid1 + 1;
                right = mid2 - 1;
            }
        }
        return -1;
    }
}
