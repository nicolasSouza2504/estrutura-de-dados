package br.com.tdd.estruturadedados.hashtable;

import java.util.LinkedList;
import java.util.Scanner;

//5. Aplicação Prática de Tabela Hash:
//○ Implemente um sistema de dicionário utilizando tabelas hash, onde o usuário
//pode armazenar e recuperar palavras com seus significados. Use
//encadeamento para resolver colisões.
//○ Adicione a funcionalidade para lidar com remoção de palavras e buscar
//palavras que não estão no dicionário.

public class HashTableDictionary {

    private static final int SIZE = 10; // Size of the hash table
    private LinkedList<Entry>[] table;

    // Constructor to initialize the hash table
    public HashTableDictionary() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Method to insert a word and its meaning into the hash table
    public void addWord(String word, String meaning) {
        int index = word.hashCode() % SIZE;
        table[index].add(new Entry(word, meaning));
    }

    // Method to retrieve the meaning of a word from the hash table
    public String getMeaning(String word) {
        int index = word.hashCode() % SIZE;
        for (Entry entry : table[index]) {
            if (entry.word.equals(word)) {
                return entry.meaning;
            }
        }
        return null; // Return null if the word is not found
    }

    // Method to remove a word from the hash table
    public boolean removeWord(String word) {
        int index = word.hashCode() % SIZE;
        for (Entry entry : table[index]) {
            if (entry.word.equals(word)) {
                table[index].remove(entry);
                return true;
            }
        }
        return false; // Return false if the word is not found
    }

    // Entry class to store the word and its meaning
    private static class Entry {
        String word;
        String meaning;

        Entry(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
        }
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTableDictionary dictionary = new HashTableDictionary();

        while (true) {
            System.out.println("\nDictionary System");
            System.out.println("1. Add Word");
            System.out.println("2. Get Meaning");
            System.out.println("3. Remove Word");
            System.out.println("4. Search Word (Not in Dictionary)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (option == 1) {
                // Add word and meaning
                System.out.print("Enter word: ");
                String word = scanner.nextLine();
                System.out.print("Enter meaning: ");
                String meaning = scanner.nextLine();
                dictionary.addWord(word, meaning);
                System.out.println("Word added successfully!");

            } else if (option == 2) {
                // Get meaning of a word
                System.out.print("Enter word to get meaning: ");
                String word = scanner.nextLine();
                String meaning = dictionary.getMeaning(word);
                if (meaning != null) {
                    System.out.println("Meaning of '" + word + "': " + meaning);
                } else {
                    System.out.println("Word not found in the dictionary.");
                }

            } else if (option == 3) {
                // Remove a word
                System.out.print("Enter word to remove: ");
                String word = scanner.nextLine();
                boolean removed = dictionary.removeWord(word);
                if (removed) {
                    System.out.println("Word '" + word + "' removed successfully.");
                } else {
                    System.out.println("Word not found in the dictionary.");
                }

            } else if (option == 4) {
                // Search for a word not in the dictionary
                System.out.print("Enter word to search (not in dictionary): ");
                String word = scanner.nextLine();
                String meaning = dictionary.getMeaning(word);
                if (meaning == null) {
                    System.out.println("Word '" + word + "' is not in the dictionary.");
                } else {
                    System.out.println("Meaning of '" + word + "': " + meaning);
                }

            } else if (option == 5) {
                // Exit
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid option! Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
