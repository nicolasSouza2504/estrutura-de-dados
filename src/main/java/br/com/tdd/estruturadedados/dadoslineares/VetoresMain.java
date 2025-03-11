package br.com.tdd.estruturadedados.dadoslineares;

import java.util.ArrayList;
import java.util.List;

public class VetoresMain {

    public static void main(String[] args) {

        // VetoresMain:

        // ○ Crie um vetor que armazene 10 números inteiros e desenvolva uma função
        // para buscar um número específico no vetor.

        // ○ Implemente uma função para remover um elemento do vetor em uma
        // posição específica.

        // Imutable array needs to create a new collection

        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int[] newVector = removeElementVector(vetor, 3);

        System.out.println(newVector);

        // Dynamic array can change its own space dynamically, but will need to change all the references after the removed element
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list.remove(3);

        System.out.println(list);
    }


    private static int[] removeElementVector(int[] vector, int index) {

        int[] newVector = new int[vector.length - 1];

        Integer indexNewArray = 0;

        for (int i = 0; i < vector.length; i++) {

            if (index == i) {
                continue;
            } else {

                newVector[indexNewArray] = vector[i];

                indexNewArray++;

            }

        }

        return newVector;
    }

}
