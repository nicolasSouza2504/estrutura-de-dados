package br.com.tdd.estruturadedados.hashtable;
// Question 5: Aplicação Prática de Tabela Hash
// Implemente um sistema de dicionário utilizando tabelas hash, onde o usuário pode armazenar e recuperar palavras com seus significados.

import java.util.Scanner;

public class HashTableWithDictionary {
    private static final int SIZE = 10;
    private HashTableWithChaining table;

    public HashTableWithDictionary() {
        table = new HashTableWithChaining();
    }

    public void addWord(String word, String meaning) {
        table.insert(word.hashCode(), meaning);
    }

    public String getMeaning(String word) {
        return table.search(word.hashCode());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTableWithDictionary dictionary = new HashTableWithDictionary();

        dictionary.addWord("java", "A popular programming language.");
        dictionary.addWord("python", "A programming language with a focus on simplicity.");

        System.out.println("Meaning of 'java': " + dictionary.getMeaning("java"));
        System.out.println("Meaning of 'python': " + dictionary.getMeaning("python"));
        scanner.close();
    }
}
