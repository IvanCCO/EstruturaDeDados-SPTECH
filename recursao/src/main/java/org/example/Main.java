package org.example;

import java.util.List;

public class Main {

    // 1 dado um numero n >= 0 devolve a soma dos numeros

    public static int somaDosNumeros(
            int numero
    ){

        if(numero == 0){
            return 0;
        }
        return numero + somaDosNumeros(numero-1);
    }


    // Devolve a soma dos elementos de um vetor de inteiro
    public static int somaVetorRecursivo(
            int[] vetor,
            int index
    ){

        if(index == vetor.length){
            return 0;
        }
        return vetor[index] + somaVetorRecursivo(vetor, index+1);
    }

    // 3 = Devolve a soma dos pares de um vetor de inteiros
    public static int somaVetorDePares(

            int[] vetor,
            int index

    ){

        if(index == vetor.length){
            return 0;
        }else{

            int valorAtual = vetor[index];

            if(valorAtual % 2 == 0){

                return vetor[index] + somaVetorDePares(vetor, index+1);

            }else{
                return somaVetorDePares(vetor, index+1);
            }

        }
    }

    // retorna a quantidade de elementos impares no vetor de inteiros

    public static int quantidadeVetorDeImpares(

            int[] vetor,
            int index
    ){

        if(index == vetor.length){
            return 0;
        }else{

            int valorAtual = vetor[index];

            if(valorAtual % 2 != 0){

                return 1 + quantidadeVetorDeImpares(vetor, index+1);

            }

            return quantidadeVetorDeImpares(vetor, index + 1);

        }
    }

    // Dado um vetor de inteiros e um valor x retorna a quantidade de vezes que o valor x foi encontrado no vetor

    public static int somaOcorrencia(

            int[] vetor,
            int index,
            int x
    ){


        if(index == vetor.length){
            return 0;
        }else{

         if(vetor[index] == x){

             return 1 + somaOcorrencia(vetor, index + 1, x);
         }

         return somaOcorrencia(vetor, index + 1, x);

        }

    }

    // 7 maior elemento do vetor iterativa e recursiva

    public static int maiorElementoIterativa(
            int[] vetor
    ){

        int maior = 0;
        boolean isPrimeiroNumero = true;

        for(int i = 0; i<vetor.length;i++){

            if(isPrimeiroNumero){
                maior = vetor[i];
                isPrimeiroNumero = false;
            }

            if(vetor[i] > maior){
                maior = vetor[i];
            }
        }

        return maior;
    }

    public static int maiorElementoRecursiva(int[] vetor, int tamanho) {
        if (tamanho == 1) {
            return vetor[0];
        } else {
            int maiorRestante = maiorElementoRecursiva(vetor, tamanho-1);
            if (maiorRestante > vetor[tamanho-1]) {
                return maiorRestante;
            }

            return vetor[tamanho-1];

        }
    }


    // retorna a soma dos digitos de um numero inteiro

    public static int somaDoInteiro(
            int numero
    ){

        if(numero < 10){
            return numero;
        }

        int ultimoDigito = numero % 10;
        int restoNumero = numero / 10;

        return ultimoDigito + somaDoInteiro(restoNumero);

    }

    // dados um numero inteiro retorna sua representação em binário
    public static String binario(
            int numero
    ){

        if(numero == 0 || numero == 1){
            return Integer.toString(numero);
        }

        int quociente = numero / 2;
        int resto = numero % 2;

        return binario(quociente) + Integer.toString(resto);
    }

    //'Iterativa e recursiva do algoritimo de euclides

    public static int euclidesIterativa(
            int a,
            int b) {
        int resto;
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }

    public static int euclidesRecursivo(
            int a,
            int b) {
        if (b == 0) {
            return a;
        } else {
            return euclidesRecursivo(b, a % b);
        }
    }



    public static void main(String[] args) {

        int[] vetorInteiros = {1,2,3,4,45,2,2};


        System.out.println(somaDosNumeros(5));
        System.out.println(somaVetorRecursivo(vetorInteiros, 0));
        System.out.println(somaVetorDePares(vetorInteiros, 0));
        System.out.println(quantidadeVetorDeImpares(vetorInteiros, 0));
        System.out.println(somaOcorrencia(vetorInteiros, 0, 2));
        System.out.println(maiorElementoIterativa(vetorInteiros));
        System.out.println(maiorElementoRecursiva(vetorInteiros, vetorInteiros.length));
        System.out.println(binario(12));
        System.out.println(euclidesRecursivo(90, 54));
        System.out.println(euclidesIterativa(90, 54));

    }

}
;