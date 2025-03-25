package br.com.tdd.estruturadedados.dadosnaolineares.heaptree;

import java.util.Arrays;

public class MaxHeapTree {

    private int[] heap;
    private int size;

    public MaxHeapTree(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void heapifyUp(int i) {

        while (i > 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }

    }

    private void heapifyDown(int i) {

        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }

    }

    private void swap(int i, int j) {

        int temp = heap[i];

        heap[i] = heap[j];
        heap[j] = temp;

    }

    public void insert(int value) {

        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        size++;

        heapifyUp(size - 1);

    }

    public int removeMax() {

        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }


        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return max;

    }

    public int getMax() {

        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return heap[0];

    }


    public void display() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

}
