package ru.zychkov.shapes;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        if (shape1.getArea() == shape2.getPerimeter()) {
            return 0;
        }

        return shape1.getArea() > shape2.getArea() ? -1 : 1;
    }
}