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

        System.out.println("Parenteses balanceados -> " + parentesesBalanceados("() () () ()"));



    }

    private static String parentesesBalanceados(String expressao) {

        Stack stack = new Stack(expressao.length());

        for (char c : expressao.toCharArray()) {

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            }

        }

        return Boolean.toString(stack.isEmpty());

    }

}
