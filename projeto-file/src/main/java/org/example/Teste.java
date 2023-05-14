package org.example;

public class Teste {


    public static void separaPositivoNegativoOrdemDiferente(int[] vetor){

        FilaObj<Integer> filaPositivos = new FilaObj<>(vetor.length);
        PilhaObj<Integer> pilhaNegativos = new PilhaObj<>(vetor.length);

        for(int i = 0; i<vetor.length; i++){

            if(vetor[i] >= 0){
                filaPositivos.enfileirar(vetor[i]);
            }else{
                pilhaNegativos.push(vetor[i]);
            }

        }

        while (!filaPositivos.estaVazia()) {
            System.out.print(filaPositivos.desenfileirar() + " ");
        }

        while (!pilhaNegativos.isEmpty()) {
            System.out.print(pilhaNegativos.pop() + " ");
        }


    }
    public static void separaPositivoNegativoEmOrdem(int[] vetor) {
        FilaObj<Integer> filaPositivos = new FilaObj<>(vetor.length);
        FilaObj<Integer> filaNegativos = new FilaObj<>(vetor.length);

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] >= 0) {
                filaPositivos.enfileirar(vetor[i]);
            } else {
                filaNegativos.enfileirar(vetor[i]);
            }
        }

        while (!filaPositivos.estaVazia()) {
            System.out.print(filaPositivos.desenfileirar() + " ");
        }

        while (!filaNegativos.estaVazia()) {
            System.out.print(filaNegativos.desenfileirar() + " ");
        }
    }

    public static void main(String[] args) {
        int[] vetor = {2,7,-3,-50,45,-4,30,-21,38};
        separaPositivoNegativoEmOrdem(vetor);
        System.out.println();
        separaPositivoNegativoOrdemDiferente(vetor);



    }
}