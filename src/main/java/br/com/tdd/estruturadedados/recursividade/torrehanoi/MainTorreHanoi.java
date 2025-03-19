package br.com.tdd.estruturadedados.recursividade.torrehanoi;

public class MainTorreHanoi {

    public static void main(String[] args) {

        TorreHanoi torreHanoi = new TorreHanoi();

        System.out.println("\n\n Pinos antes do movimento \n\n");

        torreHanoi.printPins();

        torreHanoi.changeDisksToDestination(3);

        System.out.println("\n\n Pinos após o movimento \n\n");

        torreHanoi.printPins();

        System.out.println("\n\n Count -> " + torreHanoi.count);


    }

}
