package br.com.tdd.estruturadedados.recursividade.binarytree;

public class BinaryTree {

    private Node root;

    public void insert(int data) {

        if (this.root == null) {
            this.root = new Node(data);
        } else {
            insert(data, this.root);
        }

    }

    public void insert(int data, Node node) {

        if (data < node.data) {

            if (node.left == null) {
                node.left = new Node(data);
            } else {
                insert(data, node.left);
            }

        } else {

            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insert(data, node.right);
            }

        }

    }

    public void printInOrder() {
        printInOrder(this.root);
    }


    public void printPostOrder() {
        printPostOrder(this.root);
    }

    public void printPreOrder() {
        printPreOrder(this.root);
    }

    public void printPreOrder(Node node) {

        if (node != null) {

            System.out.print(node.data + " ");

            printPreOrder(node.left);

            printPreOrder(node.right);

        }

    }

    public void printPostOrder(Node node) {


        if (node != null) {

            printPostOrder(node.left);
            printPostOrder(node.right);

            System.out.print(node.data + " ");

        }

    }


    public void printInOrder(Node node) {

        if (node != null) {

            printInOrder(node.left);

            System.out.print(node.data + " ");

            printInOrder(node.right);

        }

    }

    public Node find(int i) {
        return find(i, this.root);
    }

    public Node find(int i, Node node) {

        if (node == null) {
            return null;
        }

        if (i == node.data) {
            return node;
        } else if (i < node.data) {
            return find(i, node.left);
        } else if (i > node.data) {
            return find(i, node.right);
        } else {
            return null;
        }

    }

    public class Node {

        int data;

        BinaryTree.Node right;
        BinaryTree.Node left;

        Node(int data) {
            this.data = data;
        }

    }

}


