package br.com.tdd.estruturadedados.dadosnaolineares.grafo;

import java.util.Map;

public class GrafoMain {

    public static void main(String[] args) {
        // Criando o grafo e adicionando vértices e arestas
        Graph graph = new Graph();

        // Adicionar vértices
        for (int i = 1; i <= 4; i++) {
            graph.addVertex(i);
        }

        // Adicionar arestas ponderadas
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 4, 8);
        graph.addEdge(4, 1, 2);

        // Dijkstra: Encontrar o caminho mais curto de 1 para todos os outros nós
        System.out.println("Resultado de Dijkstra (a partir do nó 1):");
        Map<Integer, Integer> dist = graph.dijkstra(1);
        graph.printDijkstra(dist);

        // Floyd-Warshall: Encontrar o caminho mais curto entre todos os pares de nós
        System.out.println("\nResultado de Floyd-Warshall (todos os pares de nós):");
        int[][] floydDist = graph.floydWarshall();
        graph.printFloydWarshall(floydDist);

    }

}
