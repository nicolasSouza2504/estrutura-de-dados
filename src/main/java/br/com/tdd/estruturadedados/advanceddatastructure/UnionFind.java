package br.com.tdd.estruturadedados.advanceddatastructure;

import java.util.*;

//1. Implementação de Union-Find:
//○ Implemente uma estrutura de conjuntos disjuntos utilizando path
//compression e union by rank.
//○ Teste a estrutura resolvendo o problema de identificar componentes
//conectados em um grafo não direcionado.

public class UnionFind {
    private int[] parent;
    private int[] rank;

    // Construtor para inicializar o Union-Find
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Cada elemento é inicialmente seu próprio líder
        }
    }

    // Função find com path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Compressão de caminho
        }
        return parent[x];
    }

    // Função union com union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // Union by rank: coloca o elemento de menor profundidade como filho
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // Testando o Union-Find para componentes conectados em um grafo não direcionado
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(6);

        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(4, 5);

        System.out.println("Componente conectada de 0: " + uf.find(0)); // Esperado: 2
        System.out.println("Componente conectada de 3: " + uf.find(3)); // Esperado: 5
    }
}
