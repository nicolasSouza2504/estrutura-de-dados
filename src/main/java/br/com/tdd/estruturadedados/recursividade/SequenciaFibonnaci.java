package br.com.tdd.estruturadedados.recursividade;

public class SequenciaFibonnaci {

// Sequência de Fibonacci:
//
// ○ Implemente uma função recursiva que calcule o enésimo número da
// sequência de Fibonacci.
// ○ Analise o desempenho do algoritmo e sugira uma otimização (por exemplo,
// usando memoization ou uma abordagem iterativa).

    public static void main(String[] args) {

        Integer fibonacci = fibonacci(13);

        System.out.println(fibonacci);

    }

    private static Integer fibonacci(int i) {

        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        return fibonacci(i - 1) + fibonacci(i - 2);

    }

}
