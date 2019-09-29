package ru.zychkov.range;

import java.util.Scanner;

public class MainRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число начала диапазона");
        double from = scanner.nextInt();

        System.out.println("Введите число конца диапазона");
        double to = scanner.nextInt();

        System.out.println("Введите ваше число");
        double point = scanner.nextInt();

        Range range1 = new Range(from, to);

        if (range1.isInside(point)) {
            System.out.println("Ваша точка находится в диапазоне длиной " + range1.getLength());
        } else if (point < range1.getFrom()) {
            System.out.println("Ваша точка находится вне диапазона, меньше начала на " + (range1.getFrom() - point));
        } else {
            System.out.println("Ваша точка находится вне диапазона, больше конца на " + (point - range1.getTo()));
        }
    }
}
