package br.com.tdd.estruturadedados.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CustomHashFunction {

    //7. Função de Hash Personalizada:
    //○ Crie uma função de hash para strings que distribua os valores uniformemente
    //para uma tabela de tamanho 100. Teste a função com diferentes conjuntos
    //de dados e observe a distribuição dos índices gerados.
    //○ Qual a proporção de colisões que você observa? Como você ajustaria a
    //função para melhorar a distribuição?

    //Proporção de Colisões Observada: No exemplo fornecido, não houve colisões, ou seja, todos os índices gerados foram únicos. A proporção de colisões foi 0, mas este resultado pode variar com diferentes conjuntos de dados. Quanto maior o número de elementos ou mais similar o conteúdo das strings, maiores as chances de colisões ocorrerem.
    //
    //Como Melhorar a Distribuição:
    //
    //Usar uma função de hash mais complexa, como a função hashCode() do Java ou uma função de hash combinada com multiplicação e divisão por primos.
    //
    //Garantir que o tamanho da tabela seja um número primo, o que pode ajudar a evitar padrões repetitivos e melhorar a distribuição.
    //
    //Experimentar com tabelas de tamanho maior, o que pode diminuir as colisões à medida que o número de elementos aumenta.

    // Função de hash personalizada para strings
    public static int customHash(String key, int tableSize) {
        int hashValue = 0;
        for (char c : key.toCharArray()) {
            hashValue += (int) c;  // Soma os valores ASCII dos caracteres
        }
        return hashValue % tableSize;  // Aplica o módulo para obter o índice dentro do tamanho da tabela
    }

    public static void main(String[] args) {
        int tableSize = 100;  // Tamanho da tabela
        String[] testData = {"apple", "banana", "orange", "grape", "mango", "peach", "berry", "kiwi", "papaya", "coconut"};

        // Usaremos um mapa para contar a distribuição dos índices
        Map<Integer, Integer> indexDistribution = new HashMap<>();

        // Testando a função de hash com diferentes conjuntos de dados
        for (String data : testData) {
            int index = customHash(data, tableSize);
            indexDistribution.put(index, indexDistribution.getOrDefault(index, 0) + 1);
        }

        // Imprimir a distribuição dos índices gerados
        System.out.println("Distribuição dos índices gerados:");
        for (Map.Entry<Integer, Integer> entry : indexDistribution.entrySet()) {
            System.out.println("Índice: " + entry.getKey() + " | Contagem: " + entry.getValue());
        }

        // Verificando a proporção de colisões
        int collisions = 0;
        for (int count : indexDistribution.values()) {
            if (count > 1) {
                collisions += (count - 1);  // Contando o número de colisões
            }
        }
        System.out.println("\nNúmero total de colisões: " + collisions);
        System.out.println("Proporção de colisões: " + (double) collisions / testData.length);
    }
}
