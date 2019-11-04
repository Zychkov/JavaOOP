package ru.zychkov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0");
        }

        vector = new double[n];
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.getSize());
    }

    public Vector(double[] vector) {
        this.vector = Arrays.copyOf(vector, vector.length);
    }

    public Vector(int n, double[] array) {
        vector = Arrays.copyOf(array, n);
    }

    private int getSize() {
        return vector.length;
    }

    public String toString() {
        return Arrays.toString(vector).replace("[", "{").replace("]", "}");
    }

    //нестатические методы
    public Vector addition(Vector vector) {
        int length = Math.max(this.vector.length, vector.vector.length);

        if (this.vector.length < vector.vector.length) {
            double[] sourceVector = this.vector;
            this.vector = new double[length];
            System.arraycopy(sourceVector, 0, this.vector, 0, sourceVector.length);
        }

        for (int i = 0; i < vector.vector.length; i++) {
            this.vector[i] = this.vector[i] + vector.vector[i];
        }

        return this;
    }

    public Vector subtraction(Vector vector) {
        int length = Math.max(this.vector.length, vector.vector.length);

        if (this.vector.length < vector.vector.length) {
            double[] sourceVector = this.vector;
            this.vector = new double[length];
            System.arraycopy(sourceVector, 0, this.vector, 0, sourceVector.length);
        }
        for (int i = 0; i < vector.vector.length; i++) {
            this.vector[i] = this.vector[i] - vector.vector[i];
        }

        return this;
    }

    public Vector scalarMultiplication(double scalar) {
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i] = this.vector[i] * scalar;
        }

        return this;
    }

    public Vector reverse() {
        return this.scalarMultiplication(-1);
    }

    public double getLength() {
        double length = 0;

        for (double e : vector) {
            length += Math.pow(e, 2);
        }

        return Math.sqrt(length);
    }

    public void setElement(int index, double number){
        vector[index] = number;
    }
    public double getElement(int index){
        return vector[index];
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (this.getSize() != vector.getSize()) {
            return false;
        }

        for (int i = 0; i < this.vector.length; ++i) {
            if (this.vector[i] != vector.vector[i]) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vector);
        return hash;
    }

    //статические методы
    public static Vector twoVectorsAddition(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.addition(vector2);

        return newVector;
    }

    public static Vector twoVectorsSubtraction(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.subtraction(vector2);

        return newVector;
    }

    public static double vectorsScalarMultiplication(Vector vector1, Vector vector2) {
        int length = Math.min(vector1.getSize(), vector2.getSize());
        double multiplicationVector = 0;

        for (int i = 0; i < length; i++) {
            multiplicationVector += (vector1.vector[i] * vector2.vector[i]);
        }

        return multiplicationVector;
    }


}



