package ru.zychkov.range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число начала первого диапазона");
        double from1 = scanner.nextInt();

        System.out.println("Введите число конца первого диапазона");
        double to1 = scanner.nextInt();

        Range range = new Range(from1, to1);

        System.out.println("Введите число начала второго диапазона");
        double from2 = scanner.nextInt();

        System.out.println("Введите число конца второго диапазона");
        double to2 = scanner.nextInt();

        Range intersectionRange = range.getIntersection(from1, to1, from2, to2);

        if (intersectionRange == null) {
            System.out.println("Диапазоны не пересекаются");
        } else {
            System.out.printf("Диапазоны имеют общие точки %.1f и %.1f", intersectionRange.getFrom(), intersectionRange.getTo());
            System.out.println();
        }

        Range[] unionRange = range.getUnion(from1, to1, from2, to2);
        System.out.println("Результат объединения диапазонов = " + (Arrays.toString(unionRange)));

        Range[] differenceRange = range.getDifference(from1, to1, from2, to2);
        System.out.println("Результат разности диапазонов = " + (Arrays.toString(differenceRange)));
    }
}
