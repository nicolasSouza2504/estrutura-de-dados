package br.com.tdd.estruturadedados.dadoslineares.doublylinkedlist;

public class DoublyLinkedListMain {

    public static void main(String[] args) {
//    Implemente uma lista duplamente encadeada com as operações de inserir no
//    início e remover do final da lista.
//    ○ Crie uma função que percorra a lista em ambas as direções, imprimindo os
//    valores dos nós.

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertStart(1);
        doublyLinkedList.insertStart(2);
        doublyLinkedList.insertStart(3);
        doublyLinkedList.insertStart(4);
        doublyLinkedList.insertStart(5);

        System.out.println("INSERT START 1,2,3 \n\n");

        doublyLinkedList.printValues();

        doublyLinkedList.removeEnd();

        System.out.println("REMOVE END  \n\n");

        doublyLinkedList.printValues();

        System.out.println("INSERT END 10 \n\n");

        doublyLinkedList.insertEnd(10);

        doublyLinkedList.printValues();

    }

}
