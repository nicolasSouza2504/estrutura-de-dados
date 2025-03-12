package br.com.tdd.estruturadedados.dadoslineares.queue;

public class QueueMain {

    public static void main(String[] args) {
// Fila (Queue):
//
// ○ Crie uma fila e implemente as operações de enqueue e dequeue.
// ○ Modifique o código para implementar uma fila circular.
// ○ Desenvolva um programa que simule o atendimento de um banco utilizando
// uma fila simples.

        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(6);
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);

        queue.print();

        System.out.println("\n\nCircular Queue \n\n");

        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(9);
        circularQueue.enqueue(8);
        circularQueue.enqueue(7);
        circularQueue.enqueue(6);
        circularQueue.enqueue(5);
        circularQueue.enqueue(4);

        circularQueue.print();


//        ○ Desenvolva um programa que simule o atendimento de um banco utilizando
//        uma fila simples.

        Queue bankQueue = new Queue();

        bankQueue.enqueue("João");
        bankQueue.enqueue("Maria");
        bankQueue.enqueue("José");
        bankQueue.enqueue("Pedro");
        bankQueue.enqueue("Ana");

        System.out.println("\n\nBank Queue \n\n");

        bankQueue.print();
    }

}
