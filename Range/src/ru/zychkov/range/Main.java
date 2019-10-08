package ru.zychkov.range;

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
            System.out.printf("Диапазоны пересекаются в точках %.1f и %.1f", intersectionRange.getFrom(), intersectionRange.getTo());
        }

    }
}
