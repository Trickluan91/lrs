package lab9;

public class par4 {
    void main() {
        Node head = null;
        for (int i = 9; i >= 0 ; i--) {
            head = new Node(i, head);
        }

        Node ref = head;
        while(ref != null) {
            IO.print(" " + ref.value);
            ref = ref.next;
        }
    }

    private static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
