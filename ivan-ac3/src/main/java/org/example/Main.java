package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repositorio repo = new Repositorio();

        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        String opcao = "";

        while (!opcao.equals("Finalizar")) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Animacao");
            System.out.println("2 - Deletar por ID");
            System.out.println("3 - Aumentar valor pelo ID");
            System.out.println("4 - Diminuir Valor pelo ID");
            System.out.println("5 - Desfazer operacao");
            System.out.println("6 - Agendar deletar por Id");
            System.out.println("7 - Exibir todas as Animacoes");
            System.out.println("Finalizar");


            opcao = sc.nextLine();

            int id;

            switch (opcao) {

                case "1":
                    System.out.println("Digite o id da Animacao:");
                    id = in.nextInt();
                    System.out.println("Digite o valor da Animacao:");
                    double valor = in.nextDouble();
                    System.out.println("Digite o ano de lancamento da Animacao:");
                    int anoLancamento = in.nextInt();
                    System.out.println("Digite a duracao do episodio da Animacao:");
                    double duracaoEp = in.nextDouble();
                    System.out.println("Digite o título da Animacao:");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o Estudio da Animacao:");
                    String estudio = sc.nextLine();
                    Animacao tema = new Animacao(id, valor, anoLancamento, titulo, duracaoEp, estudio);
                    repo.adicionalistaAnimacao(tema);
                    break;

                case "2":
                    System.out.println("Digite o id da Animacao:");
                    id = in.nextInt();
                    repo.deletarPeloId(id);
                    break;

                case "3":
                    System.out.println("Digite o id da Animacao:");
                    id = in.nextInt();
                    System.out.println("Digite o valor a ser aumentado da Animacao:");
                    double value = in.nextDouble();
                    repo.aumentarValorPeloId(id, value);
                    break;
                case "4":
                    System.out.println("Digite o id da Animacao:");
                    id = in.nextInt();
                    System.out.println("Digite o valor a ser diminuido da Animacao:");
                    double value1 = in.nextDouble();
                    repo.diminuirValorPeloId(id, value1);
                    break;

                case "5":
                    System.out.println("Quantas operacoes deseja desfazer?");
                    id = in.nextInt();
                    repo.desfazer(id);
                    break;

                case "6":
                    System.out.println("Quantas operacoes deseja desfazer?");
                    break;
                case "7":
                    repo.exibir();
                    break;


                case "Finalizar":
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }

    }

}

