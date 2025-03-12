package br.com.tdd.estruturadedados.dadoslineares.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    List queue;

    public Queue() {
        queue = new ArrayList();
    }

    public void enqueue(Object value) {
        queue.add(value);
    }

    public void dequeue() {
        queue.remove(0);
    }

    public void print() {
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.get(i));
        }
    }
}
