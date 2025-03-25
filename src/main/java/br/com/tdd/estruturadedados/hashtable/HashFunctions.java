package br.com.tdd.estruturadedados.hashtable;
// Question 1: Implementação de Funções de Hash
        // Implementação de uma função de hash simples que recebe uma chave inteira e retorna um índice em uma tabela de tamanho 10.
        
        public class HashFunctions {
            public static int simpleHash(int key) {
                return key % 10; // Função simples de hash
            }
            
            public static int stringHash(String key) {
                int hashValue = 0;
                for (char c : key.toCharArray()) {
                    hashValue += (int) c;
                }
                return hashValue % 10; // Função de hash para string
            }
            
            public static void main(String[] args) {
                System.out.println("Hash de 25: " + simpleHash(25)); // Saída esperada: 5
                System.out.println("Hash de 'apple': " + stringHash("apple")); // Saída esperada depende da string
            }
        }
