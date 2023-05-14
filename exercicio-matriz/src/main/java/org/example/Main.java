package org.example;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void exibirMatriz(int[][] matriz) {
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.printf("%7d ", matriz[linha][coluna]);
            }
            System.out.println();
        }
    }

    public static void exercicioUm(){
        Scanner in = new Scanner(System.in);
        int[][] matriz = new int[2][3];

        for(int linha = 0; linha < matriz.length; linha++){
            for(int coluna = 0; coluna < matriz[linha].length; coluna++){
                matriz[linha][coluna] = in.nextInt();
            }
        }

        exibirMatriz(matriz);
    }

    public static void exercicioTres(int[][] matrizUm, int[][] matrizDois){

        // calcular soma das matrizes e retorna um  matriz com a soma

        boolean isMatrizValida = matrizUm.length == matrizDois.length
                && matrizUm[0].length == matrizDois[0].length;

        int[][] somaMatriz = new int[matrizUm.length][matrizUm[0].length];
        if(isMatrizValida){
            for(int i =0; i<matrizUm.length; i++){
                for(int j =0; j<matrizUm[i].length; j++){
                    somaMatriz[i][j] = matrizUm[i][j] + matrizDois[i][j];
                }
            }
        }
        exibirMatriz(somaMatriz);
    }



    public static void exercicioTres(){

        Scanner in = new Scanner(System.in);

        int[][] matriz = new int[3][3];

        int[] vetorSoma = new int[3];

        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){

                matriz[i][j] = in.nextInt();

                vetorSoma[j] += matriz[i][j];

            }
        }
        for(int i = 0; i<vetorSoma.length; i++){
            System.out.println(vetorSoma[i]);
        }
    }

    public static void exercicioQuatro(int numTeste){

        Scanner in = new Scanner(System.in);

        boolean isNumeroValido = numTeste > 1 && numTeste < 6;

        int[][] matriz = new int[numTeste][numTeste];

        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;
        int ultimoElemento = matriz.length-1;

        for(int i =0; i<matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = in.nextInt();

                if(i == j){
                    somaDiagonalPrincipal += matriz[i][j];
                }
                if(j == ultimoElemento){
                    somaDiagonalSecundaria += matriz[i][j];
                    ultimoElemento--;
                }
            }
        }

        System.out.println("A diagonal principal é " + somaDiagonalPrincipal);
        System.out.println("A diagonal Secundária é " + somaDiagonalSecundaria);

    }

    public static boolean quadradoMagico(int[][] matriz){

        int n = matriz.length;
        int[] somas = new int[2 * matriz.length + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; matriz[i].length < n; j++) {

                // somas [10, 0, 0, 2, 4, 5, 0, 0]

                somas[i] += matriz[i][j];
                somas[n + j] += matriz[i][j];

                if (i == j) {
                    somas[2 * n] += matriz[i][j];
                }
                if (i + j == n - 1) {
                    somas[2 * n + 1] += matriz[i][j];
                }
            }
        }
        return Arrays.stream(somas).distinct().count() == 1;
    }

    public static void exercicioSeis(){

        Scanner sc = new Scanner(System.in);

        // Solicitação do valor maxAluno
        int maxAluno = 0;

        do {
            System.out.print("Digite o valor de maxAluno (entre 5 e 15): ");
            maxAluno = sc.nextInt();
        } while (maxAluno < 5 || maxAluno > 15);

        // Criação dos vetores e matriz
        String[] aluno = new String[maxAluno];
        double[][] notas = new double[maxAluno][2];
        double[] media = new double[2];

        // Solicitação dos nomes dos alunos
        System.out.println("\nDigite os nomes dos alunos:");
        for (int i = 0; i < maxAluno; i++) {
            System.out.print((i + 1) + "º aluno: ");
            aluno[i] = sc.next();
        }

        // Solicitação das notas dos alunos
        System.out.println("\nDigite as notas dos alunos:");

        for (int i = 0; i < maxAluno; i++) {
            System.out.print("Notas do(a) aluno(a) " + aluno[i] + ":\nAC1: ");
            notas[i][0] = sc.nextDouble();
            System.out.print("AC2: ");
            notas[i][1] = sc.nextDouble();

            if((notas[i][0] < 0 || notas[i][0] > 10)
            || (notas[i][1] < 0 || notas[i][1] > 10)){
                System.out.println("\nNotas devem ser de 0 a 10\n");
                i--;
            }

        }

        // Cálculo das médias
        for (int i = 0; i < maxAluno; i++) {
            media[0] += notas[i][0];
            media[1] += notas[i][1];
        }
        media[0] /= maxAluno;
        media[1] /= maxAluno;

        // Exibição dos dados
        System.out.println("\n----------------------------------------------------------");
        System.out.printf("| %-10s | %8s | %8s |\n", "NOME DO ALUNO", "NOTA AC1", "NOTA AC2");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < maxAluno; i++) {
            System.out.printf("| %-10s | %8.1f | %8.1f |\n", aluno[i], notas[i][0], notas[i][1]);
        }
        System.out.println("----------------------------------------------------------");
        System.out.printf("| %-10s | %8.1f | %8.1f |\n", "MÉDIA:", media[0], media[1]);
        System.out.println("----------------------------------------------------------");
    }



    public static void main(String[] args) {

        int[][] matriz1 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        int[][] matriz2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

//        exercicioTres(matriz1, matriz2);

//        exercicioQuatro(3);


//        System.out.println(quadradoMagico(matriz1));

        exercicioSeis();


    }
}