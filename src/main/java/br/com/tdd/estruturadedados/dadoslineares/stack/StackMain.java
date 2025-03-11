package br.com.tdd.estruturadedados.dadoslineares.stack;

public class StackMain {

    public static void main(String[] args) {
//         Pilha (Stack):
//  ○ Implemente uma pilha e adicione operações para verificar se a pilha está
//  cheia ou vazia.
//  ○ Utilize uma pilha para verificar se uma expressão aritmética contém
//  parênteses balanceados (exemplo: ((1+2) * (3/4))).

        Stack stack = new Stack(5);

        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        System.out.println(stack.top());

        stack.pop();

        System.out.println(stack.top());




    }

}
