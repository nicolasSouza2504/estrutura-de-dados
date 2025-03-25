package br.com.tdd.estruturadedados.dadosnaolineares.heaptree;

public class HeapTreeMain {

    public static void main(String[] args) {
        //3. Heaps:
        //○ Implemente um max-heap e escreva funções para inserir um novo elemento
        //e remover o maior elemento.
        //○ Use um heap para implementar uma fila de prioridades que sempre retorna o
        //maior valor.

        MaxHeapTree heapTree = new MaxHeapTree(10);

        heapTree.insert(10);
        heapTree.insert(20);
        heapTree.insert(15);
        heapTree.insert(40);

        System.out.println("Max Heap: ");

        heapTree.display();

        heapTree.removeMax();

        heapTree.display();

        heapTree.getMax();
        heapTree.removeMax();


        // queue of priorities
        MaxHeapTree priorityQueue = new MaxHeapTree(10);

        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(15);
        priorityQueue.insert(40);

        System.out.println("Priority Queue: ");

        priorityQueue.display();

        priorityQueue.removeMax();
        priorityQueue.removeMax();
        priorityQueue.removeMax();

        priorityQueue.display();

    }

}
