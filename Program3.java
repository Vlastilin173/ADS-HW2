// Урок 3. Структуры данных. Связный список.
// Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор).
// Односвязный

import java.util.Scanner;
public class Program3 {

    private static Node head;

    public static void main(String[] args) {

        int n = InputNotNegativeNumber("Введите размер списка: ", 10);
        for (int i = n; i > 0; i--) {
            add(RndInteger(-99, 100));
        }
        System.out.println("\nИсходный список: ");
        PrintLinkedList();
        Reverse();

        // Вывод развернутого списка
        System.out.println("\nРезультат: ");
        PrintLinkedList();
    }

    static int InputNotNegativeNumber(String msg, int defaultValue) {
        Scanner iScanner = new Scanner(System.in);
        int num = 0;
        System.out.print(msg);
        if (iScanner.hasNextInt()) {
            num = iScanner.nextInt();
            if (num < 0) {
                num = defaultValue;
            }
        } else {
            num = defaultValue;
        }
        iScanner.close();
        return num;
    }

    static int RndInteger(int a, int b) {
        return (int) (Math.random() * (b - a)) + a;

    }

    static void add(int val) {
        Node node = new Node();
        node.value = val;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    // Разворот односвязного списка без рекурсии
    static void Reverse() {
        if (head != null) {
            Node current = head.next;
            head.next = null;
            while (current != null) {
                Node tmp = current.next;
                current.next = head;
                head = current;
                current = tmp;
            }
        }
    }

    // Вывод
    static void PrintLinkedList() {
        if (head == null) {
            System.out.println("[]");
        } else {
            Node tmp = head;
            System.out.printf("[%d]", tmp.value);
            while (tmp.next != null) {
                tmp = tmp.next;
                System.out.printf(" -> [%d]", tmp.value);
            }
            System.out.print(" -> null\n");
        }

    }
}

class Node {
    public int value;
    public Node next;
}