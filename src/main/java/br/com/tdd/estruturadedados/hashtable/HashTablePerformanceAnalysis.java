package br.com.tdd.estruturadedados.hashtable;

import java.util.LinkedList;

public class HashTablePerformanceAnalysis {

    // Size of the table
    private int size;
    private LinkedList<Entry>[] table;

    // Constructor to initialize the hash table
    public HashTablePerformanceAnalysis(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Insert method
    public void insert(int key, String value) {
        int index = key % size;
        table[index].add(new Entry(key, value));
    }

    // Search method
    public String search(int key) {
        int index = key % size;
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    // Remove method
    public void remove(int key) {
        int index = key % size;
        table[index].removeIf(entry -> entry.key == key);
    }

    // Entry class to store key-value pairs
    private static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    // Method to measure time for insert, search, and remove operations
    public static void main(String[] args) {

        //6. Análise de Desempenho:
        //○ Crie uma tabela hash e insira 500 elementos utilizando uma função de hash
        //eficiente. A tabela deve ser ajustada para diferentes tamanhos (50, 100,
        //250).
        //○ Meça o tempo médio de busca e remoção de elementos e discuta como o
        //tamanho da tabela afeta o desempenho.

        int numElements = 500; // Number of elements to insert

        // Sizes of the hash table
        int[] sizes = {50, 100, 250};

        for (int size : sizes) {
            System.out.println("\nTesting with table size: " + size);

            // Create the hash table with the given size
            HashTablePerformanceAnalysis hashTable = new HashTablePerformanceAnalysis(size);

            // Insert elements into the hash table and measure time
            long insertStartTime = System.nanoTime();
            for (int i = 0; i < numElements; i++) {
                hashTable.insert(i, "Value" + i);
            }
            long insertEndTime = System.nanoTime();
            long insertDuration = insertEndTime - insertStartTime;
            System.out.println("Time to insert 500 elements: " + insertDuration + " ns");

            // Measure search operation time
            long searchStartTime = System.nanoTime();
            for (int i = 0; i < numElements; i++) {
                hashTable.search(i);
            }
            long searchEndTime = System.nanoTime();
            long searchDuration = searchEndTime - searchStartTime;
            System.out.println("Time to search 500 elements: " + searchDuration + " ns");

            // Measure remove operation time
            long removeStartTime = System.nanoTime();
            for (int i = 0; i < numElements; i++) {
                hashTable.remove(i);
            }
            long removeEndTime = System.nanoTime();
            long removeDuration = removeEndTime - removeStartTime;
            System.out.println("Time to remove 500 elements: " + removeDuration + " ns");

            // Calculate the average time for each operation
            System.out.println("Average time per operation:");
            System.out.println("Insert: " + (insertDuration / (double) numElements) + " ns");
            System.out.println("Search: " + (searchDuration / (double) numElements) + " ns");
            System.out.println("Remove: " + (removeDuration / (double) numElements) + " ns");

        }

    }

}
