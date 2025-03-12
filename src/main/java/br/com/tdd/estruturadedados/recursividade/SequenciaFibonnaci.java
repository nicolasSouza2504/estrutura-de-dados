package br.com.tdd.estruturadedados.recursividade;

import java.util.HashMap;
import java.util.Map;

public class SequenciaFibonnaci {

// Sequência de Fibonacci:
//
// ○ Implemente uma função recursiva que calcule o enésimo número da
// sequência de Fibonacci.
//Analise o desempenho do algoritmo e sugira uma otimização (por exemplo,
//usando memoization ou uma abordagem iterativa).

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        Integer fibonacci = fibonacciWithCache(13);

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

    private static Integer fibonacciWithCache(int i) {

        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }

        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        Integer fibonacci = fibonacciWithCache(i - 1) + fibonacciWithCache(i - 2);

        cache.put(i, fibonacci);

        return fibonacci;

    }

}
