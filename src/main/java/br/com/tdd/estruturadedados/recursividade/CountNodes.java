package br.com.tdd.estruturadedados.recursividade;

import br.com.tdd.estruturadedados.dadoslineares.simplylinkedlist.SimplyLinkedList;

public class CountNodes {

    public static void main(String[] args) {

        // Complexidade Linear

        SimplyLinkedList simplyLinkedList = new SimplyLinkedList();

        for (int i = 0; i < 100; i++) {
            simplyLinkedList.insertStart(i);
        }

        System.out.println(simplyLinkedList.countNodes());

    }

}
