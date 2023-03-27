package org.example;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] vetor = {4, 2, 6, 1, 9, 3, 8, 7, 5};
        int[] copia1 = vetor.clone();
        int[] copia2 = vetor.clone();

        String divider = "/ * /".repeat(20);

        System.out.println("selectionSort:");
        selectionSort(vetor);
        exibeVetor(vetor);
        System.out.println(divider);

        System.out.println("selectionSortOtimizado:");
        selectionSortOtimizado(copia1);
        exibeVetor(copia1);
        System.out.println(divider);

        System.out.println("bubbleSort:");
        bubbleSort(copia2);
        exibeVetor(copia2);
        System.out.println(divider);

        int valor = 5; // valor a ser procurado na busca binária
        int posicao = buscaBinaria(copia2, valor);
        if (posicao == -1) {
            System.out.println("O valor " + valor + " não foi encontrado no vetor.");
        } else {
            System.out.println("O valor " + valor + " foi encontrado na posição " + posicao + " do vetor.");
        }

    }

    public static void selectionSort(int[] vetor) {
        int comp = 0;
        int troca = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                comp++;
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            troca++;
            int temp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = temp;
        }

        System.out.println("Comparações: " + comp);
        System.out.println("Trocas: " + troca);
    }

    public static void selectionSortOtimizado(int[] vetor) {
        int comp = 0;
        int troca = 0;

        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                comp++;
                if (vetor[j] < vetor[min]) {
                    min = j;
                }
            }
            if (min != i) {
                troca++;
                int temp = vetor[i];
                vetor[i] = vetor[min];
                vetor[min] = temp;
            }
        }
        System.out.println("Comparações: " + comp);
        System.out.println("Trocas: " + troca);
    }

        public static void bubbleSort(int[] vetor){
            int n = vetor.length;
            int comparacoes = 0;
            int trocas = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparacoes++;
                    if (vetor[j] > vetor[j + 1]) {
                        trocas++;
                        int temp = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = temp;
                    }
                }
            }
            System.out.println("Número de comparações: " + comparacoes);
            System.out.println("Número de trocas: " + trocas);
        }

    public static void exibeVetor(int[] vetor) {
        Arrays.stream(vetor).forEach(System.out::println);
    }

    public static int buscaBinaria(int[] vetor, int chave) {
        int esquerda = 0;
        int direita = vetor.length - 1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (vetor[meio] == chave) {
                return meio;
            }
            else if (vetor[meio] < chave) {
                esquerda = meio + 1;
            }
            else {
                direita = meio - 1;
            }
        }
        return -1;
    }


}




