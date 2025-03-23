package br.com.tdd.estruturadedados.dadosnaolineares.avltree;

public class AvlTreeMain {

    public static void main(String[] args) {

//            Árvores AVL:
//            ○ Implemente uma árvore AVL com as operações de inserção e remoção,
//            garantindo que a árvore permaneça balanceada após cada operação.
//
        AvlTree tree = new AvlTree();

        // Insert nodes into the AVL tree
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        // Inorder traversal (sorted order)
        System.out.println("Inorder traversal of the AVL tree:");

        tree.inorder();

        // Delete a node
        tree.delete(10);

        System.out.println("Inorder traversal after deleting 10:");

        tree.inorder();

    }

}
