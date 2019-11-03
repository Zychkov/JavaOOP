package ru.zychkov.shapes.main;

import ru.zychkov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Rectangle(1, 5), new Triangle(2, 2, 3, 3, 4, 4), new Square(4),
                new Circle(2), new Rectangle(3, 4), new Triangle(0, 1, 2, 3, 4, 5), new Square(5), new Circle(3.5)};

        Shape maxArea = foundShapeWithMaxArea(shapes);
        Shape secondPerimeter = foundShapeWithSecondPerimeter(shapes);

        System.out.printf("Фигура с максимальной площадью - %s, Площадь = %.2f%n", maxArea.toString(), maxArea.getArea());
        System.out.printf("Фигура со вторым по величине периметром - %s. Периметр = %.2f%n", secondPerimeter.toString(), secondPerimeter.getPerimeter());
    }

    private static Shape foundShapeWithMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());

        return shapes[0];
    }

    private static Shape foundShapeWithSecondPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[1];
    }
}

