package br.com.tdd.estruturadedados.dadoslineares.simplylinkedlist;

public class SimplyLinkedListMain {

    public static void main(String[] args) {


        //○ Implemente uma lista simplesmente encadeada com as seguintes operações:
        //inserir no início, inserir no final e remover de uma posição específica.
        //○ Modifique o código anterior para permitir a busca de um elemento por valor.

        SimplyLinkedList simplyLinkedList = new SimplyLinkedList();

        simplyLinkedList.insertStart(1);
        simplyLinkedList.insertEnd(2);
        simplyLinkedList.insertEnd(3);
        simplyLinkedList.insertEnd(4);

        simplyLinkedList.remove(2);

        simplyLinkedList.printValues();

    }



}
