package br.com.tdd.estruturadedados.hashtable;
// Question 4: Comparação de Técnicas de Tratamento de Colisões
// Implemente tanto o encadeamento quanto o endereçamento aberto e compare o desempenho de ambas as técnicas em um conjunto de 1000 inserções e buscas.

public class CompareHashTableTechniques {

    public static void main(String[] args) {

        // Teste para tabela com encadeamento

        HashTableWithChaining chainingTable = new HashTableWithChaining();

        for (int i = 0; i < 1000; i++) {
            chainingTable.insert(i, "Value" + i);
        }

        System.out.println("Chaining search for key 500: " + chainingTable.search(500));

        // Teste para tabela com probing linear
        HashTableWithLinearProbing probingTable = new HashTableWithLinearProbing();

        for (int i = 0; i < 1000; i++) {
            probingTable.insert("Value" + i);
        }

        System.out.println("Probing search for key 'Value500': " + probingTable.search("Value500"));

    }

}

