package ru.zychkov.vector.main;

import ru.zychkov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = new double[]{1, 10};
        double[] array2 = new double[]{2, 18};

        Vector vector1 = new Vector(array1);
        Vector vector2 = new Vector(array2);

        /*
        int n = -3;

        Vector vector3 = new Vector(n);
         */

        vector1.addition(vector2);
        System.out.println("Прибавление к вектору другого вектора: " + vector1);

        vector1.subtraction(vector2);
        System.out.println("Вычитание из вектора другого вектора: " + vector1);

        int scalar = 5;

        vector1.scalarMultiplication(scalar);
        System.out.println("Умножение вектора на скаляр: " + vector1.toString() + " * " + scalar + " = " + vector1);

        vector1.reverse();
        System.out.println("Разворот вектора: " + vector1);

        double length = vector1.getLength();
        System.out.printf("Получение длины вектора: %.2f%n", length);

        vector1.setElement(0, 5);
        vector1.setElement(1, 10);
        System.out.println("Замена элемента по индексу: " + vector1);

        System.out.println("Сложение двух векторов: " + Vector.twoVectorsAddition(vector1, vector2));

        System.out.println("Вычитание векторов: " + Vector.twoVectorsSubtraction(vector1, vector2));

        System.out.println("Скалярное произведение векторов: " + Vector.vectorsScalarMultiplication(vector1, vector2));
    }
}
