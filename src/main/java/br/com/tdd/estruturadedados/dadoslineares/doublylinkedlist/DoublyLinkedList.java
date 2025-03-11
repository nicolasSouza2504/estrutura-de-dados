package br.com.tdd.estruturadedados.dadoslineares.doublylinkedlist;

public class DoublyLinkedList {
//    Implemente uma lista duplamente encadeada com as operações de inserir no
//início e remover do final da lista.
//○ Crie uma função que percorra a lista em ambas as direções, imprimindo os
//valores dos nós.

    private Node head;
    private Node tail;

    public void insertStart(int value) {

        if (this.head == null) {

            this.head = new Node(value);
            this.tail = this.head;

        } else {

            Node newNode = new Node(value);

            newNode.next = this.head;

            this.head.previous = newNode;

            this.head = newNode;

        }

    }

    public void insertEnd(int value) {

        if (this.head == null) {

            this.head = new Node(value);
            this.tail = this.head;

        } else {

            Node node = new Node(value);

            this.tail.next = node;

            this.tail = node;

        }

    }

    public void removeEnd() {

        if (this.tail != null) {

            this.tail = this.tail.previous;

            this.tail.next = null;

        }


    }

    private class Node {

        int data;

        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void printValues() {

        Node current = this.head;

        while(current.next != null) {

            System.out.println("Node value -> " + current.data + "\n");

            System.out.println("Node next value -> " + current.next.data + "\n");

            if (current.previous != null) {
                System.out.println("Node previous value -> " + current.previous.data + "\n");
            }

            current = current.next;

        }

    }

}
