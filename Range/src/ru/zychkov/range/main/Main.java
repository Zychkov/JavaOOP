package ru.zychkov.range.main;

import ru.zychkov.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число начала первого диапазона");
        double from1 = scanner.nextInt();

        System.out.println("Введите число конца первого диапазона");
        double to1 = scanner.nextInt();

        Range range1 = new Range(from1, to1);

        System.out.println("Введите число начала второго диапазона");
        double from2 = scanner.nextInt();

        System.out.println("Введите число конца второго диапазона");
        double to2 = scanner.nextInt();

        Range range2 = new Range(from2, to2);

        Range intersectionRange = range1.getIntersection(range2);

        if (intersectionRange == null) {
            System.out.println("Диапазоны не пересекаются");
        } else {
            System.out.printf("Диапазоны имеют общие точки %.1f и %.1f", intersectionRange.getFrom(), intersectionRange.getTo());
            System.out.println();
        }

        Range[] unionRange = range1.getUnion(range2);
        System.out.println("Результат объединения диапазонов = " + (Arrays.toString(unionRange)));

        Range[] differenceRange = range1.getDifference(range2);
        System.out.println("Результат разности диапазонов = " + (Arrays.toString(differenceRange)));
    }
}
