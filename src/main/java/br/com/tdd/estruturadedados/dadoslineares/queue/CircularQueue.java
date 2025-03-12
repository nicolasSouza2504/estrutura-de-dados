package br.com.tdd.estruturadedados.dadoslineares.queue;

public class CircularQueue {

    private int[] queue;
    private int inicio;
    private int fim;
    private int tamanho;

    public CircularQueue(int tamanho) {

        this.queue = new int[tamanho];

        this.inicio = 0;

        this.fim = 0;

        this.tamanho = 0;

    }

    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Fila cheia");
        } else {

            queue[fim] = value;

            fim = (fim + 1) % queue.length;

            tamanho++;

        }

    }

    public void dequeue() {

        if (isEmpty()) {
            System.out.println("Fila vazia");
        } else {

            inicio = (inicio + 1) % queue.length;

            tamanho--;

        }

    }

    public void print() {

        for (int i = 0; i < tamanho; i++) {
            System.out.println(queue[(inicio + i) % queue.length]);
        }

    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == queue.length;
    }

}
