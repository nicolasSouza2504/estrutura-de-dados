package br.com.tdd.estruturadedados.advanceddatastructure;

//3. Árvore B:
//○ Implemente uma árvore B com um grau mínimo de 3 e insira os seguintes
//valores: 10, 20, 5, 6, 12, 30, 7, 17. Mostre a estrutura da árvore após cada
//inserção.
//○ Adicione a funcionalidade de remoção e demonstre a remoção dos valores 6
//e 17
import java.util.Arrays;


public class BinaryTree {

    // Define a árvore B com grau mínimo de 3
    private static class BTreeNode {
        int[] keys;
        BTreeNode[] children;
        int numKeys;
        boolean isLeaf;

        BTreeNode(int degree, boolean isLeaf) {
            keys = new int[2 * degree - 1];
            children = new BTreeNode[2 * degree];
            this.isLeaf = isLeaf;
            this.numKeys = 0;
        }
    }

    private BTreeNode root;
    private int degree;

    public BinaryTree(int degree) {
        this.degree = degree;
        this.root = new BTreeNode(degree, true);
    }

    private void remove(BTreeNode node, int key) {
        int index = findKey(node, key);

        if (index < node.numKeys && node.keys[index] == key) {
            if (node.isLeaf) {
                // Se o nó é folha, basta remover a chave
                removeFromLeaf(node, index);
            } else {
                // Se o nó não é folha, precisamos tratar a remoção mais complexa
                removeFromNonLeaf(node, index);
            }
        } else {
            // Se a chave não está no nó, procura recursivamente na árvore
            if (node.isLeaf) {
                System.out.println("Chave não encontrada: " + key);
                return;
            }

            boolean flag = (index == node.numKeys);
            if (node.children[index].numKeys < degree) {
                fill(node, index);
            }

            if (flag && index > node.numKeys) {
                remove(node.children[index - 1], key);
            } else {
                remove(node.children[index], key);
            }
        }
    }
    private int findKey(BTreeNode node, int key) {
        int index = 0;
        while (index < node.numKeys && node.keys[index] < key) {
            index++;
        }
        return index;
    }

    private void removeFromLeaf(BTreeNode node, int index) {
        for (int i = index + 1; i < node.numKeys; i++) {
            node.keys[i - 1] = node.keys[i];
        }
        node.numKeys--;
    }

    private void removeFromNonLeaf(BTreeNode node, int index) {
        int key = node.keys[index];
        if (node.children[index].numKeys >= degree) {
            int pred = getPred(node, index);
            node.keys[index] = pred;
            remove(node.children[index], pred);
        } else if (node.children[index + 1].numKeys >= degree) {
            int succ = getSucc(node, index);
            node.keys[index] = succ;
            remove(node.children[index + 1], succ);
        } else {
            merge(node, index);
            remove(node.children[index], key);
        }
    }

    private int getPred(BTreeNode node, int index) {
        BTreeNode current = node.children[index];
        while (!current.isLeaf) {
            current = current.children[current.numKeys];
        }
        return current.keys[current.numKeys - 1];
    }

    private void fill(BTreeNode node, int index) {
        if (index != 0 && node.children[index - 1].numKeys >= degree) {
            borrowFromPrev(node, index);
        } else if (index != node.numKeys && node.children[index + 1].numKeys >= degree) {
            borrowFromNext(node, index);
        } else {
            if (index != node.numKeys) {
                merge(node, index);
            } else {
                merge(node, index - 1);
            }
        }
    }

    private void borrowFromPrev(BTreeNode node, int index) {
        BTreeNode child = node.children[index];
        BTreeNode sibling = node.children[index - 1];

        for (int i = child.numKeys - 1; i >= 0; i--) {
            child.keys[i + 1] = child.keys[i];
        }
        if (!child.isLeaf) {
            for (int i = child.numKeys; i >= 0; i--) {
                child.children[i + 1] = child.children[i];
            }
        }

        child.keys[0] = node.keys[index - 1];

        if (!child.isLeaf) {
            child.children[0] = sibling.children[sibling.numKeys];
        }

        node.keys[index - 1] = sibling.keys[sibling.numKeys - 1];

        child.numKeys++;
        sibling.numKeys--;
    }

    private int getSucc(BTreeNode node, int index) {
        BTreeNode current = node.children[index + 1];
        while (!current.isLeaf) {
            current = current.children[0];
        }
        return current.keys[0];
    }

    private void borrowFromNext(BTreeNode node, int index) {
        BTreeNode child = node.children[index];
        BTreeNode sibling = node.children[index + 1];

        child.keys[child.numKeys] = node.keys[index];
        if (!child.isLeaf) {
            child.children[child.numKeys + 1] = sibling.children[0];
        }

        node.keys[index] = sibling.keys[0];

        for (int i = 1; i < sibling.numKeys; i++) {
            sibling.keys[i - 1] = sibling.keys[i];
        }

        if (!sibling.isLeaf) {
            for (int i = 1; i <= sibling.numKeys; i++) {
                sibling.children[i - 1] = sibling.children[i];
            }
        }

        child.numKeys++;
        sibling.numKeys--;
    }

    private void merge(BTreeNode node, int index) {
        BTreeNode child = node.children[index];
        BTreeNode sibling = node.children[index + 1];

        child.keys[degree - 1] = node.keys[index];

        for (int i = 0; i < sibling.numKeys; i++) {
            child.keys[i + degree] = sibling.keys[i];
        }

        if (!child.isLeaf) {
            for (int i = 0; i <= sibling.numKeys; i++) {
                child.children[i + degree] = sibling.children[i];
            }
        }

        for (int i = index + 1; i < node.numKeys; i++) {
            node.keys[i - 1] = node.keys[i];
        }

        for (int i = index + 2; i <= node.numKeys; i++) {
            node.children[i - 1] = node.children[i];
        }

        child.numKeys += sibling.numKeys + 1;
        node.numKeys--;
    }

    public void insert(int key) {
        BTreeNode root = this.root;
        if (root.numKeys == (2 * degree - 1)) {
            // Se a raiz estiver cheia, criamos uma nova raiz
            BTreeNode newNode = new BTreeNode(degree, false);
            newNode.children[0] = root;
            splitChild(newNode, 0);
            this.root = newNode;
        }
        insertNonFull(this.root, key);
    }

    private void insertNonFull(BTreeNode node, int key) {
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

            BTreeNode child = node.children[i];

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

    private void splitChild(BTreeNode parent, int index) {
        BTreeNode fullChild = parent.children[index];
        BTreeNode newChild = new BTreeNode(degree, fullChild.isLeaf);

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

    private void printTree(BTreeNode node, String indent, boolean last) {
        System.out.println(indent + "+- " + (node.isLeaf ? "Leaf" : "Internal") + " Node, keys: " + Arrays.toString(Arrays.copyOf(node.keys, node.numKeys)));

        if (!node.isLeaf) {
            for (int i = 0; i <= node.numKeys; i++) {
                printTree(node.children[i], indent + (last ? "   " : "|  "), i == node.numKeys);
            }
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    public static void main(String[] args) {

        BinaryTree bTree = new BinaryTree(3);

        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        bTree.insert(17);

        bTree.printTree();

    }
}
