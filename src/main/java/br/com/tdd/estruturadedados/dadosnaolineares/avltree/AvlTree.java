package br.com.tdd.estruturadedados.dadosnaolineares.avltree;

public class AvlTree {

class Node {

    int data, height;
    Node left, right;

    public Node(int data) {

        this.data = data;

        this.height = 1;  // height of node when created is 1

    }

}

    private Node root;

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation (RR)
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;  // New root
    }

    // Left rotation (LL)
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;  // New root
    }

    // Insert a node
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        // Step 1: Perform the normal BST insertion
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {  // Duplicate values are not allowed
            return node;
        }

        // Step 2: Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Step 3: Get the balance factor and check whether it is unbalanced
        int balance = getBalance(node);

        // Left Left Case (LL)
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case (RR)
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case (LR)
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case (RL)
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;  // No balance needed
    }

    // Delete a node
    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        // Step 1: Perform the normal BST delete
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {  // Node with data to be deleted found
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;
                root = temp;  // Copy the non-null child
            } else {
                // Get the inorder successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }

        if (root == null) {
            return root;
        }

        // Step 2: Update the height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Step 3: Get the balance factor and check whether it is unbalanced
        int balance = getBalance(root);

        // Left Left Case (LL)
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Right Right Case (RR)
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Left Right Case (LR)
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case (RL)
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;  // No balancing needed
    }

    // Get the node with the minimum value
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Inorder traversal to print the tree
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

}
