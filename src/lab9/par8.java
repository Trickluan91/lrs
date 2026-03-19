package lab9;

import java.util.Scanner;

public class par8 {
    private Node head = new Node();
    private final Scanner sc = new Scanner(System.in);

    void main() {
        IO.println("Введите команду:");
        IO.println("1. Добавить элементы в начало.");
        IO.println("2. Добавить элементы в конец.");
        IO.println("3. Вывести список.");
        IO.println("4. Добавить в начало.");
        IO.println("5. Добавить в конец.");
        IO.println("6. Добавить по указанному индексу.");
        IO.println("7. Удалить голову.");
        IO.println("8. Удалить хвост.");
        IO.println("9. Удалить по указанному индексу.");

        IO.println("10. Добавить элементы в начало (рекурсивно).");
        IO.println("11. Добавить элементы в конец (рекурсивно).");
        IO.println("12. Вывести список (рекурсивно).");

        IO.println("99. Завершить программу.");

        int choice = sc.nextInt();
        while(choice != 99) {
            switch(choice) {
                case 1: createHead(); break;
                case 2: createTail(); break;
                case 3: IO.println(toString()); break;
                case 4: addFirst(); break;
                case 5: addLast(); break;
                case 6: insert(); break;
                case 7: removeFirst(); break;
                case 8: removeLast(); break;
                case 9: remove(); break;

                case 10: {
                    IO.println("Введи -1, чтобы перестать вводить");
                    createHeadRec();
                    break;
                }
                case 11: {
                    IO.println("Введи -1, чтобы перестать вводить");
                    createTailRec(head);
                    break;
                }
                case 12: IO.println(toStringRec(head, new StringBuilder())); break;
            }

            IO.println("Введи команду");
            choice = sc.nextInt();
        }
    }

    void createHead() {
        IO.println("Сколько элементов добавить?");
        int n = sc.nextInt();
        IO.println(String.format("Жду %d элементов", n));

        for (int i = 0; i < n; i++) {
            if(head.data == null) {
                head.data = sc.nextInt();
            } else {
                head = new Node(sc.nextInt(), head);
            }
        }
    }

    void createTail() {
        IO.println("Сколько элементов добавить?");
        int n = sc.nextInt();
        IO.println(String.format("Жду %d элементов", n));

        Node tail = head;
        while(tail.next != null) tail = tail.next;

        for (int i = 0; i < n; i++) {
            if(tail.data == null) {
                tail.data = sc.nextInt();
            } else {
                tail.next = new Node(sc.nextInt(), null);
                tail = tail.next;
            }
        }
    }

    void addFirst() {
        IO.println("Введи число");
        if(head.data == null) {
            head.data = sc.nextInt();
        } else {
            head = new Node(sc.nextInt(), head);
        }
    }

    void addLast() {
        IO.println("Введи число");

        Node tail = head;
        while(tail.next != null) tail = tail.next;

        if(tail.data == null) tail.data = sc.nextInt();
        else tail.next = new Node(sc.nextInt(), null);
    }

    void insert() {
        IO.println("Введи индекс, куда вставлять число");
        int index = sc.nextInt();
        if(index < 1) {
            IO.println("Нет такого номера");
            return;
        }

        Node prev = head;
        Node cur = head;
        for (int i = 1; i < index; i++) {
            if(cur == null) {
                IO.println("Нет такого номера");
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        IO.println("Введи число");
        if(prev == cur) {
            head = new Node(sc.nextInt(), cur);
        } else {
            prev.next = new Node(sc.nextInt(), cur);
        }
    }

    void removeFirst() {
        if(head.next == null) return;
        head = head.next;
    }

    void removeLast() {
        Node cur = head;
        if(cur.next == null) return;
        if(cur.next.next == null) {
            cur.next = null;
            return;
        }

        while(cur.next.next != null) {
            cur = cur.next;
        }
        cur.next = null;
    }

    void remove() {
        IO.println("Введи индекс, какое число удалить");
        int index = sc.nextInt();
        if(index < 1) {
            IO.println("Нет такого номера");
            return;
        }

        if(index == 1) {
            if (head.next == null) {
                head.data = null;
            } else {
                head = head.next;
            }
            return;
        }

        Node prev = head;
        Node cur = head;
        for (int i = 1; i < index; i++) {
            if(cur == null) {
                IO.println("Нет такого номера");
                return;
            }
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while(cur != null){
            sb.append(cur).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }

    void createHeadRec() {
        int n = sc.nextInt();
        if(n == -1) return;
        if(head.data == null) head.data = n;
        else head = new Node(n, head);
        createHeadRec();
    }

    void createTailRec(Node tail) {
        while (tail.next != null) tail = tail.next;
        int n = sc.nextInt();
        if(n == -1) return;
        tail.next = new Node(n, null);
        createTailRec(tail.next);
    }

    String toStringRec(Node cur, StringBuilder sb) {
        if(cur == null) return sb.toString();
        sb.append(cur).append(" ");
        return toStringRec(cur.next, sb);
    }

    static class Node {
        Integer data;
        Node next;

        public Node() {}

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String toString(){
            return data == null ? "" : data.toString();
        }
    }
}
