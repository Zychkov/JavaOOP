package ru.zychkov.shapes.main;

import ru.zychkov.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Rectangle(1, 5), new Triangle(2, 2, 3, 3, 4, 4), new Square(4),
                new Circle(2), new Rectangle(3, 4), new Triangle(0, 1, 2, 3, 4, 5), new Square(5), new Circle(3.5)};

        Shape maxArea = getMaxShape(shapes);
        Shape secondPerimeter = getSecondPerimeter(shapes);

        System.out.printf("Фигура с максимальной площадью - %s, Площадь = %.2f%n", maxArea.toString(), maxArea.getArea());
        System.out.printf("Фигура с вторым по величине периметром - %s. Периметр = %.2f%n", secondPerimeter.toString(), secondPerimeter.getPerimeter());
    }

    private static Shape getMaxShape(Shape[] shapes) {
        Shape maxArea = shapes[0];

        for (int i = 1; i < shapes.length; ++i) {
            if (shapes[i].getArea() > maxArea.getArea()) {
                maxArea = shapes[i];
            }
        }
        return maxArea;
    }

    private static Shape getSecondPerimeter(Shape[] shapes) {
        double[] shapesArray = new double[shapes.length];

        Shape secondPerimeter = shapes[0];
        int i = 0;

        for (Shape e : shapes) {
            shapesArray[i] = e.getPerimeter();
            ++i;
        }

        Arrays.sort(shapesArray);

        for (Shape e : shapes) {
            if (shapesArray[shapesArray.length - 2] == e.getPerimeter()) {
                secondPerimeter = e;
                break;
            }
        }

        return secondPerimeter;
    }
}
