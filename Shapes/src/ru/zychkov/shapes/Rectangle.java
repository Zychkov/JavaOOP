package ru.zychkov.shapes;

public class Rectangle implements Shape {
    private double lengthA;
    private double lengthB;

    public Rectangle(double lengthA, double lengthB) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
    }

    public double getArea() {
        return lengthA * lengthB;
    }

    public double getPerimeter() {
        return 2 * (lengthA + lengthB);
    }

    public double getHeight() {
        return lengthA;
    }

    public double getWidth() {
        return lengthB;
    }

    @Override
    public String toString() {
        return "Rectangle" + "{" + lengthA + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) obj;
        return lengthA == rectangle.lengthA && lengthB == rectangle.lengthB;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(lengthA);
        hash = prime * hash + Double.hashCode(lengthB);
        return hash;
    }

}


