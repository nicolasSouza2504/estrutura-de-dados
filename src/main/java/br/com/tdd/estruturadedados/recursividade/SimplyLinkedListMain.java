package br.com.tdd.estruturadedados.recursividade;

import br.com.tdd.estruturadedados.dadoslineares.simplylinkedlist.SimplyLinkedList;

public class SimplyLinkedListMain {


    public static void main(String[] args) {
//            Soma dos Elementos de uma Lista Encadeada:
//○ Crie uma função recursiva que percorra uma lista simplesmente encadeada e
//retorne a soma de todos os elementos da lista.

        SimplyLinkedList simplyLinkedList = new SimplyLinkedList();

        simplyLinkedList.insertStart(1);
        simplyLinkedList.insertStart(3);
        simplyLinkedList.insertStart(5);
        simplyLinkedList.insertStart(7);
        simplyLinkedList.insertStart(9);
        simplyLinkedList.insertStart(11);

        System.out.println("Sum values -> " + simplyLinkedList.sumValues());

    }

}
