package ru.zychkov.list;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int count;

    public SinglyLinkedList() {
        this.head = null;
        count = 0;
    }

    public SinglyLinkedList(T data) {
        head = new Node<>(data, null);
        count = 1;
    }

    private void checkException(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Узла с таким индексом не существует");
        }
    }

    public int getListCount() {
        return count;
    }

    public Node<T> getFirstNode() {
        return head;
    }

    public Node<T> getNodeByIndex(int index) {
        checkException(index);
        int tempIndex = 0;

        for (Node<T> p = head; p != null; p = p.getNext()) {
            if (tempIndex == index) {
                return p;
            }

            ++tempIndex;
        }

        return null;
    }

    public T getNodeDataByIndex(int index) {
        checkException(index);
        return getNodeByIndex(index).getData();
    }

    public T setNodeDataByIndex(T data, int index) {
        checkException(index);
        Node<T> temp = getNodeByIndex(index);
        T oldData = temp.getData();
        temp.setData(data);

        return oldData;
    }

    public T delNodeByIndex(int index) {
        checkException(index);
        --count;

        Node<T> current = head;

        if (index == 0) {
            head = head.getNext();
            return current.getData();
        }

        current = getNodeByIndex(index - 1);

        T removedData = current.getNext().getData();
        current.setNext(current.getNext().getNext());

        return removedData;
    }

    public void addFirstNode(T data) {
        Node<T> node = head;
        head = new Node<>(data, node);

        count++;
    }

    public void addNodeByIndex(T data, int index) {
        checkException(index);

        if (index == 0) {
            addFirstNode(data);
            return;
        } else {
            Node<T> element = getNodeByIndex(index - 1);
            Node<T> temp = new Node<>(data, element.getNext());
            element.setNext(temp);
        }

        ++count;
    }

    public Node<T> delFirstNode() {
        Node<T> p = head;
        head = head.getNext();

        --count;

        return p;
    }

    public boolean delNodeByValue(T data) {
        if (head.getData() == data) {
            head = head.getNext();
            --count;

            return true;
        }

        for (Node<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData() == data) {
                assert prev != null;
                prev.setNext(p.getNext());
                --count;

                return true;
            }
        }

        return false;
    }

    public void reverse() {
        Node<T> node = head;
        Node<T> prev = null;

        while (node != null) {
            Node<T> temp = node.getNext();
            node.setNext(prev);

            head = node;
            prev = node;
            node = temp;
        }
    }

    public SinglyLinkedList<T> copy() {
        if (head == null) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>(head.getData());
        Node<T> currentCopy = listCopy.getFirstNode();

        Node<T> current = head;

        for (int i = 1; i < count; i++) {
            current = current.getNext();

            currentCopy.setNext(new Node<>(current.getData(), null));
            currentCopy = currentCopy.getNext();
        }
        listCopy.count = this.count;
        return listCopy;
    }

    public String toString() {
        StringBuilder br = new StringBuilder("[");
        for (Node p = head; p != null; p = p.getNext()) {
            br.append(p.getData().toString());

            if (p.getNext() != null) {
                br.append(", ");
            }
        }

        br.append("]");
        return br.toString();
    }
}


/*
•	получение размера списка
•	получение значение первого элемента
•	получение/изменение значения по указанному индексу.
Изменение значения по индексу пусть выдает старое значение.
•	удаление элемента по индексу, пусть выдает значение элемента
•	вставка элемента в начало
•	вставка элемента по индексу
•	удаление узла по значению, пусть выдает true, если элемент был удален
•	удаление первого элемента, пусть выдает значение элемента
•	разворот списка за линейное время
•	копирование списка

 */