package br.com.tdd.estruturadedados.dadoslineares.stack;

public class Stack {

    char[] stack;
    int topo;

    Stack(Integer quantidade) {

        this.stack = new char[quantidade];
        this.topo = 0;

    }

    public void push(char value) {

        stack[topo] = value;

        topo ++;

    }

    public void pop() {
        topo--;
    }

    public char top() {

        if (!isEmpty()) {
            return stack[topo-1];
        } else {
            return '\0';
        }

    }

    public boolean isEmpty() {
        return topo == 0;
    }

    public boolean isFull() {
        return topo == stack.length;
    }

}
