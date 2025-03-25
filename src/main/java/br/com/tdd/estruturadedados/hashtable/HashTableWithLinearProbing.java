package br.com.tdd.estruturadedados.hashtable;

// Question 3: Endereçamento Aberto (Probing Linear)
// Implemente uma tabela hash utilizando probing linear para resolver colisões.

public class HashTableWithLinearProbing {

    private static final int SIZE = 10;
    private String[] table;

    public HashTableWithLinearProbing() {
        table = new String[SIZE];
    }

    public void insert(String value) {
        int index = value.hashCode() % SIZE;
        while (table[index] != null) {
            index = (index + 1) % SIZE; // Probing linear
        }
        table[index] = value;
    }

    public String search(String value) {
        int index = value.hashCode() % SIZE;
        while (table[index] != null) {
            if (table[index].equals(value)) {
                return table[index];
            }
            index = (index + 1) % SIZE;
        }
        return null;
    }

    public void remove(String value) {
        int index = value.hashCode() % SIZE;
        while (table[index] != null) {
            if (table[index].equals(value)) {
                table[index] = null;
                break;
            }
            index = (index + 1) % SIZE;
        }
    }

    public static void main(String[] args) {


        HashTableWithLinearProbing hashTable = new HashTableWithLinearProbing();

        hashTable.insert("apple");
        hashTable.insert("banana");

        System.out.println(hashTable.search("apple")); // Saída esperada: "apple"

        hashTable.remove("apple");

        System.out.println(hashTable.search("apple")); // Saída esperada: null

    }
}
