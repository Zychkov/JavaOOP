package ru.zychkov.list.Main;

import ru.zychkov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Получаем List Int'ов и корректируем его");
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 9; i >= 0; i--) {
            list.addFirstNode(i);
        }

        System.out.println(list);
        list.setNodeDataByIndex(10, 7);
        System.out.println(list);

        System.out.println();

        System.out.println("Считаем количество узлов и удаляем первый");
        System.out.println(list.getListCount());
        list.delFirstNode();
        System.out.println(list);

        System.out.println();

        System.out.println("Получаем / изменяем данные по индексу");
        System.out.println(list.getNodeByIndex(6).getData());
        list.setNodeDataByIndex(7, 6);
        System.out.println(list);

        System.out.println();

        System.out.println("Добавляем / удаляем данные по индексу");
        list.addNodeByIndex(0, 0);
        System.out.println(list);
        list.delNodeByIndex(9);
        System.out.println(list);

        System.out.println();

        System.out.println("Удаление данных по значению");
        System.out.println(list.delNodeByValue(8));
        System.out.println(list.delNodeByValue(55));
        System.out.println(list);

        System.out.println();

        System.out.println("Реверс список");
        list.reverse();
        System.out.println(list);

        System.out.println();

        System.out.println("Копирование списка");
        SinglyLinkedList<Integer> secondList = list.copy();
        System.out.println(secondList);

        System.out.println();

        System.out.println("Ловим Exception");
        list.addNodeByIndex(0, 8);
    }
}
