package br.com.tdd.estruturadedados.advanceddatastructure;

import java.util.*;

//2. Aplicação de Union-Find em Algoritmos de Grafos:
//○ Utilizando sua implementação de Union-Find, implemente o Algoritmo de
//Kruskal para encontrar a árvore geradora mínima de um grafo ponderado.
//○ Dado um conjunto de arestas e vértices, determine se existe um ciclo no
//grafo.
public class KruskalAlgorithm {

    // Classe para armazenar as arestas
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Função para encontrar a árvore geradora mínima usando Kruskal
    public static List<Edge> kruskal(int numVertices, List<Edge> edges) {
        UnionFind uf = new UnionFind(numVertices);
        List<Edge> mst = new ArrayList<>();

        // Ordena as arestas pelo peso
        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Processa as arestas em ordem crescente
        for (Edge edge : edges) {
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v);
                mst.add(edge);  // Adiciona à árvore geradora mínima
            }
        }

        return mst;
    }

    public static boolean hasCycle(int numVertices, List<Edge> edges) {
        UnionFind uf = new UnionFind(numVertices);

        for (Edge edge : edges) {
            int rootU = uf.find(edge.u);
            int rootV = uf.find(edge.v);

            if (rootU == rootV) {
                return true;  // Se as raízes são iguais, há um ciclo
            }
            uf.union(edge.u, edge.v);
        }

        return false; // Não há ciclo
    }


    // Testando o algoritmo de Kruskal
    public static void main(String[] args) {

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        List<Edge> mst = kruskal(4, edges);

        System.out.println("Árvore geradora mínima:");

        for (Edge edge : mst) {
            System.out.println("Aresta: " + edge.u + " - " + edge.v + " com peso: " + edge.weight);
        }


        List<Edge> edgesCycle = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(1, 2, 20));
        edges.add(new Edge(2, 0, 30)); // Isso cria um ciclo

        System.out.println("Ciclo no grafo: " + hasCycle(3, edgesCycle));

    }
}
