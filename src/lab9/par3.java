package lab9;

import java.util.Scanner;

public class par3 {
    void main() {
        IO.println("Enter number to add in array. Ctrl+D to exit");
        Scanner in = new Scanner(System.in);

        Node node = new Node();
        while(in.hasNextInt()) {
            node = add(node, in.nextInt());
        }

        print(node.prev);
    }

    Node add(Node node, int x) {
        Node next = new Node();
        next.prev = node;

        node.data = x;
        node.next = next;
        return next;
    }

    void print(Node node){
        if(node.prev != null) print(node.prev);
        IO.print(node.data);
        IO.print(" ");
    }

    private static class Node{
        Integer data;
        Node next;
        Node prev;
    }
}
