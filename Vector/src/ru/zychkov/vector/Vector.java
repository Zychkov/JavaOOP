package ru.zychkov.vector;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Неправильная размерность вектора");
        }
        vector = new double[n];
    }

    public Vector(Vector v) {
        this.vector = v.vector;
    }

    public Vector(double[] vector) {
        this.vector = vector;
    }


}



