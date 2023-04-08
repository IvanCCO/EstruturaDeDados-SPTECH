package org.example;

public class Main {
    public static void main(String[] args) {

        ListaObj test = new ListaObj<>(4);

        test.adiciona(1);
        test.adiciona(2);
        test.adiciona(3);

        test.removerPorElemento(2);
        test.exibirVetor();

    }
}