package com.university.lab5;

/**
 * Небольшой тестовый класс для проверки корректности реализации.
 * Запускается как обычная java-программа и печатает результат тестов.
 */
public class TernarySearchTest {
    public static void main(String[] args) {
        int passed = 0;
        int total = 0;

        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 1, 2, 3, 4, 5 }, 3), 2))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 1, 2, 3, 4, 5 }, 1), 0))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 1, 2, 3, 4, 5 }, 5), 4))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 1, 2, 3, 4, 5 }, 6), -1))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] {}, 1), -1))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 2, 4, 6, 8, 10, 12 }, 8), 3))
            passed++;
        total++;
        if (assertEq(TernarySearch.ternarySearch(new int[] { 2, 4, 6, 8, 10, 12 }, 2), 0))
            passed++;

        System.out.printf("Tests passed: %d/%d%n", passed, total);
        if (passed != total)
            System.exit(1); // ненулевой код если есть провал
    }

    private static boolean assertEq(int a, int b) {
        boolean ok = a == b;
        if (!ok)
            System.out.printf("FAILED: expected %d but got %d%n", b, a);
        return ok;
    }
}
