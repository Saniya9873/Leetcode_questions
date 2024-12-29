public class Circular_linkedlist {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node tail;
    // public void CircularLinkedList() {
    //     this.tail = null;
    // }

    // Add at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    // Add at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Add at a specific position
    public void addSpecific(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);
        if (tail == null) {
            if (position == 1) {
                tail = newNode;
                tail.next = tail;
            } else {
                System.out.println("Position out of range.");
            }
            return;
        }

        Node current = tail.next;
        for (int i = 1; i < position - 1 && current != tail; i++) {
            current = current.next;
        }

        if (position == 1) {
            newNode.next = tail.next;
            tail.next = newNode;
        } else if (current != tail || position - 1 == 0) {
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail) {
                tail = newNode;
            }
        } else {
            System.out.println("Position out of range.");
        }
    }

    // Delete the first node
    public void deleteFirst() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
    }

    // Delete the last node
    public void deleteLast() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        if (tail.next == tail) {
            tail = null;
            return;
        }

        Node current = tail.next;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = tail.next;
        tail = current;
    }

    // Delete a specific node
    public void deleteSpecific(int position) {
        if (position < 1 || tail == null) {
            System.out.println("Invalid position or list is empty.");
            return;
        }

        if (position == 1) {
            deleteFirst();
            return;
        }

        Node current = tail.next;
        for (int i = 1; i < position - 1 && current.next != tail.next; i++) {
            current = current.next;
        }

        if (current.next == tail.next) {
            System.out.println("Position out of range.");
        } else {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
        }
    }

    // Display the list
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail.next;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println("(circular)");
    }

    public static void main(String[] args) {
        Circular_linkedlist list = new Circular_linkedlist();

        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addSpecific(15, 2);

        System.out.println("After adding elements:");
        list.display();

        list.deleteFirst();
        System.out.println("After deleting the first element:");
        list.display();

        list.deleteLast();
        System.out.println("After deleting the last element:");
        list.display();

        list.deleteSpecific(2);
        System.out.println("After deleting the second element:");
        list.display();
    }
}


