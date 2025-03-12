package br.com.tdd.estruturadedados.recursividade;

public class FatorialRecursivo {
    public static void main(String[] args) {
//        1. Fatorial Recursivo:
//          ○ Implemente uma função recursiva para calcular o fatorial de um número
//          inteiro nnn.
//          ○ Determine a complexidade de tempo do algoritmo.

        Integer fatorial = fatorial(12);

// O(n) Complexidade linear o tempo de execução aumenta linearmente com o tamanho da entrada.

        System.out.println(fatorial);

    }

    private static Integer fatorial(int i) {

        if (i == 0) {
            return 1;
        }

        return i * fatorial(i - 1);

    }
}
