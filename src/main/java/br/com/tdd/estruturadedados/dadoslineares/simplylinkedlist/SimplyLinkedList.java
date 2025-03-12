package br.com.tdd.estruturadedados.dadoslineares.simplylinkedlist;

public class SimplyLinkedList {

    private Node head;

    public void remove(int index) {

        if (this.head == null) {
            return;
        }

        if (index == 0) {

            this.head = this.head.next;

            return;

        }

        Node current = this.head;
        Node previous = null;

        for (int i = 0; i < index; i++) {

            if (current.next == null) {
                return;
            }

            previous = current;
            current = current.next;

        }

        previous.next = current.next;

    }

    public void insertEnd(int value) {

        if (this.head == null) {
            this.head = new Node(value);
        } else {

            Node current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node(value);

        }

    }

    public void insertStart(int value) {

        if (this.head == null) {
            this.head = new Node(value);
        } else {

            Node newHead = new Node(value);

            newHead.next = this.head;

            this.head = newHead;

        }

    }

    public int sumValues() {
        return sumValues(this.head);
    }

    public int sumValues(Node node) {
        return node != null ? node.data + sumValues(node.next) : 0;
    }

    private class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void printValues() {

        Node current = this.head;

        while (current != null) {

            System.out.println(current.data);

            current = current.next;

        }

    }

}
