package br.com.tdd.estruturadedados.advanceddatastructure;

import java.util.*;

//4. Árvore B+:
//○ Implemente uma árvore B+ com grau mínimo de 2 e insira os valores: 15, 5, 25, 10, 20, 30, 35.
//○ Mostre a estrutura da árvore após cada inserção, destacando a organização
//dos nós internos e folhas.
public class BPlusTree {

    // Classe para armazenar um nó da árvore B+
    private static class Node {
        int[] keys;
        Node[] children;
        Node next;  // Apontador para o próximo nó folha
        int numKeys;
        boolean isLeaf;

        Node(int degree, boolean isLeaf) {
            keys = new int[2 * degree - 1];
            children = new Node[2 * degree];
            this.isLeaf = isLeaf;
            this.numKeys = 0;
        }
    }

    private Node root;
    private int degree;

    public BPlusTree(int degree) {
        this.degree = degree;
        this.root = new Node(degree, true);  // Começa com uma folha
    }

    // Método de inserção
    public void insert(int key) {
        Node root = this.root;
        if (root.numKeys == (2 * degree - 1)) {
            // Se a raiz estiver cheia, criamos uma nova raiz
            Node newRoot = new Node(degree, false);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            this.root = newRoot;
        }
        insertNonFull(this.root, key);
    }

    // Método de inserção em um nó que não está cheio
    private void insertNonFull(Node node, int key) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            // Se for folha, insira a chave no nó de forma ordenada
            while (i >= 0 && node.keys[i] > key) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            // Se não for folha, busque o nó onde a chave deve ser inserida
            while (i >= 0 && node.keys[i] > key) {
                i--;
            }
            i++;

            Node child = node.children[i];

            // Se o filho está cheio, dividimos ele
            if (child.numKeys == (2 * degree - 1)) {
                splitChild(node, i);

                // Após a divisão, podemos precisar verificar qual filho deve ser escolhido
                if (node.keys[i] < key) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    // Função para dividir um filho cheio
    private void splitChild(Node parent, int index) {
        Node fullChild = parent.children[index];
        Node newChild = new Node(degree, fullChild.isLeaf);

        parent.children[index + 1] = newChild;
        parent.keys[index] = fullChild.keys[degree - 1];
        parent.numKeys++;

        // Copiar a segunda metade das chaves para o novo nó filho
        for (int i = degree; i < fullChild.numKeys; i++) {
            newChild.keys[i - degree] = fullChild.keys[i];
        }
        if (!fullChild.isLeaf) {
            for (int i = degree; i <= fullChild.numKeys; i++) {
                newChild.children[i - degree] = fullChild.children[i];
            }
        }

        fullChild.numKeys = degree - 1;
    }

    // Método para imprimir a estrutura da árvore B+
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node node, String indent, boolean last) {
        System.out.println(indent + "+- " + (node.isLeaf ? "Leaf" : "Internal") + " Node, keys: " + Arrays.toString(Arrays.copyOf(node.keys, node.numKeys)));

        if (!node.isLeaf) {
            for (int i = 0; i <= node.numKeys; i++) {
                printTree(node.children[i], indent + (last ? "   " : "|  "), i == node.numKeys);
            }
        } else {
            // Quando chegar nas folhas, encadeia as folhas
            Node current = node;
            while (current != null) {
                System.out.print(Arrays.toString(Arrays.copyOf(current.keys, current.numKeys)) + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        BPlusTree bTree = new BPlusTree(2);  // Grau mínimo 2

        // Inserir os valores: 15, 5, 25, 10, 20, 30, 35
        int[] values = {15, 5, 25, 10, 20, 30, 35};
        for (int value : values) {
            bTree.insert(value);
        }

        // Imprimir a estrutura da árvore B+ após cada inserção
        System.out.println("Árvore B+ após inserções:");
        bTree.printTree();
    }
}
