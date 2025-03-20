package br.com.tdd.estruturadedados.dadosnaolineares.binarysearchtree;

import br.com.tdd.estruturadedados.recursividade.binarytree.BinaryTree;

public class BinarySearchTreeMain {

    public static void main(String[] args) {

        //// 1. Árvores Binárias:
        //// ○ Implemente uma árvore binária e crie as funções para realizar os percursos
        //// in-order, pre-order e post-order.
        //// ○ Dado um conjunto de números, construa uma árvore binária de busca (BST)
        //// e implemente funções para inserir, buscar e remover elementos da árvore.

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(100);

        for (int i = 0; i < 150; i += 5) {
            binaryTree.insert(i);
        }


        binaryTree.printPostOrder();
        binaryTree.printPreOrder();
        binaryTree.printInOrder();

        System.out.println("\n\n Node founded " + binaryTree.find(145));

        binaryTree.remove(110);

        System.out.println(" Printing pos remove ");

        binaryTree.printPostOrder();
        binaryTree.printPreOrder();
        binaryTree.printInOrder();

    }

}
