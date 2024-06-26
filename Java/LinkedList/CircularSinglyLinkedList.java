package Java.LinkedList;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedList {
    private Node head;
    private Node tail;

    CircularSinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    public boolean search(int data) {
        if (head == null) {
            return false;
        }
        Node current = head;
        do {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Node current = head;
        Node prev = null;

        do {
            prev = current;
            current = current.next;
            if (current.data == data) {
                break;
            }
        } while (current != head);

        if (current == head) {
            return;
        }

        prev.next = current.next;
        if (current == tail) {
            tail = prev;
        }
    }

    public void show() {
        if (head == null) {
            return;
        }
        Node current = head;
        do {
            System.out.println("The data address is " + current);
            System.out.println("The data is : " + current.data);
            System.out.println("The next address is : " + current.next);
            System.out.println(" ");

            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.delete(30);
        list.show();
    }
}
