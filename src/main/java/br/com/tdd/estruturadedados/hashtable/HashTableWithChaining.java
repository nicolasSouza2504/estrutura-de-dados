package br.com.tdd.estruturadedados.hashtable;
// Question 2: Encadeamento
        // Implemente uma tabela hash com encadeamento, onde cada índice da tabela armazena uma lista encadeada de pares (chave, valor).
        
        import java.util.LinkedList;

        public class HashTableWithChaining {
            private static final int SIZE = 10;
            private LinkedList<Entry>[] table;

            public HashTableWithChaining() {
                table = new LinkedList[SIZE];
                for (int i = 0; i < SIZE; i++) {
                    table[i] = new LinkedList<>();
                }
            }

            public void insert(int key, String value) {
                int index = key % SIZE;
                table[index].add(new Entry(key, value));
            }

            public String search(int key) {
                int index = key % SIZE;
                for (Entry entry : table[index]) {
                    if (entry.key == key) {
                        return entry.value;
                    }
                }
                return null;
            }

            public void remove(int key) {
                int index = key % SIZE;
                table[index].removeIf(entry -> entry.key == key);
            }

            private static class Entry {
                int key;
                String value;

                Entry(int key, String value) {
                    this.key = key;
                    this.value = value;
                }
            }
            
            public static void main(String[] args) {
                HashTableWithChaining hashTable = new HashTableWithChaining();
                hashTable.insert(1, "one");
                hashTable.insert(2, "two");
                System.out.println(hashTable.search(1)); // Saída esperada: "one"
                hashTable.remove(1);
                System.out.println(hashTable.search(1)); // Saída esperada: null
            }
        }
