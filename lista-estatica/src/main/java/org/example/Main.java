package org.example;

public class Main {
    public static void main(String[] args) {

        int[] vetor = new int[5];

        ListaEstatica test = new ListaEstatica(vetor);


        test.adiciona(1);
        test.adiciona(2);
        test.adiciona(3);
        test.adiciona(4);
        test.adiciona(5);

        test.removerPorElemento(2);

        test.exibirVetor();


    }
}