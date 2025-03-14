package br.com.tdd.estruturadedados.recursividade.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args) {

//            3. Travessia em Árvores:
//            ○ Implemente um algoritmo recursivo para realizar o percurso in-order de uma
//            árvore binária.
//
//            ○ Altere o código para implementar os percursos pre-order e post-order.

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(2);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(10);
        binaryTree.insert(0);
        binaryTree.insert(11);

        System.out.println("\n In Order \n");

        binaryTree.printInOrder();

        System.out.println("\n Post Order \n");

        binaryTree.printPostOrder();

        System.out.println("\n Pre Order \n");

        binaryTree.printPreOrder();


//        Busca em uma Árvore Binária de Busca:
//        ○ Implemente uma função recursiva para buscar um valor em uma árvore
//        binária de busca.
//
//        ○ Qual é a complexidade de tempo da busca em termos de nnn, onde nnn é o
//        número de nós na árvore?
//
//        R: O(log n) – Logarítmico: A operação reduz o problema em proporções constantes a cada passo.
//

        binaryTree.insert(25);
        binaryTree.insert(50);

        BinaryTree.Node node = binaryTree.find(34);

        System.out.println("\n\nNode Founded -> Value: " + (node != null ? node.data : null));

    }

}
