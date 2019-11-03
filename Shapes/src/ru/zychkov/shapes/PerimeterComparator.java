package ru.zychkov.shapes;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getPerimeter() == shape2.getPerimeter()) {
            return 0;
        }

        return shape1.getPerimeter() > shape2.getPerimeter() ? -1 : 1;
    }
}
