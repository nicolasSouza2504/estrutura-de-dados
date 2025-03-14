package br.com.tdd.estruturadedados.recursividade.torrehanoi;

public class MainTorreHanoi {

    public static void main(String[] args) {

        TorreHanoi torreHanoi = new TorreHanoi();

        System.out.println("\n\n Pinos antes do movimento \n\n");

        torreHanoi.printPins();

        torreHanoi.changeDiscsToPin(3);

        System.out.println("\n\n Pinos após o movimento \n\n");

        torreHanoi.printPins();


    }

}
