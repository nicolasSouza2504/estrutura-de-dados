package br.com.tdd.estruturadedados.dadosnaolineares.grafo;

import java.util.*;

public class Graph {
    private Map<Integer, Map<Integer, Integer>> adjList; // Grafo ponderado (direcionado)

    public Graph() {
        adjList = new HashMap<>();
    }

    // Adicionar um vértice ao grafo
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    // Adicionar uma aresta ponderada (direcionada)
    public void addEdge(int vertex1, int vertex2, int weight) {
        adjList.get(vertex1).put(vertex2, weight);
    }

    // Algoritmo de Dijkstra
    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Inicializar distâncias e fila de prioridade
        for (Integer vertex : adjList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
            prev.put(vertex, null);
        }
        dist.put(start, 0);
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            // Se já encontramos um caminho mais curto, ignoramos
            if (currentDist > dist.get(currentNode)) continue;

            // Processar vizinhos
            for (Map.Entry<Integer, Integer> entry : adjList.get(currentNode).entrySet()) {
                int neighbor = entry.getKey();
                int weight = entry.getValue();
                int newDist = currentDist + weight;

                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    prev.put(neighbor, currentNode);
                    pq.add(new int[]{neighbor, newDist});
                }
            }
        }

        return dist;
    }

    public int[][] floydWarshall() {
        // Step 1: Create a mapping from vertex to index
        Map<Integer, Integer> vertexToIndex = new HashMap<>();
        int index = 0;

        for (Integer vertex : adjList.keySet()) {
            vertexToIndex.put(vertex, index++);
        }

        // Step 2: Initialize distance matrix
        int n = vertexToIndex.size();
        int[][] dist = new int[n][n];

        // Step 3: Initialize all distances to a large value (infinity)
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Step 4: Distance from each vertex to itself is 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Step 5: Fill in the direct distances from the adjacency list
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : adjList.entrySet()) {
            int u = entry.getKey();
            int uIndex = vertexToIndex.get(u);

            for (Map.Entry<Integer, Integer> neighbor : entry.getValue().entrySet()) {
                int v = neighbor.getKey();
                int vIndex = vertexToIndex.get(v);
                int weight = neighbor.getValue();
                dist[uIndex][vIndex] = weight;
            }
        }

        // Step 6: Apply the Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }


    // Método para exibir o caminho mais curto usando Dijkstra
    public void printDijkstra(Map<Integer, Integer> dist) {
        for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
            System.out.println("Distância do nó " + entry.getKey() + " é " + entry.getValue());
        }
    }

    // Método para exibir o resultado de Floyd-Warshall
    public void printFloydWarshall(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

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
