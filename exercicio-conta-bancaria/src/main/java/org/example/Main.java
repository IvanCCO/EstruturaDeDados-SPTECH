package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        PilhaObj<Operacao> pilha = new PilhaObj<>(10);
        FilaObj<Operacao> fila = new FilaObj<>(10);

        int count = 0;

        ContaBancaria contaUm = new ContaBancaria(1, 302.10);
        ContaBancaria contaDois = new ContaBancaria(2, 231.21);


        String mensagem = """
                                
                1 - Debitar valor
                2 - Creditar valor
                3 - Desfazer operação
                4 - Agendar Operação
                5 - Executar operações agendadas
                6 - Sair
                      
                """;

        while (true) {

            System.out.println(mensagem);

            String resposta = in.next();

            if (resposta.equalsIgnoreCase("6")) {
                break;
            }

            int numeroConta = 0;
            double valor = 0;


            switch (resposta) {

                case "1":

                    System.out.println("Digite o número da conta que deseja: ");
                    numeroConta = sc.nextInt();
                    System.out.println("Digite o valor desejado: ");
                    valor = sc.nextDouble();

                    if (numeroConta == 1) {
                        if (contaUm.debitar(valor)) {
                            Operacao operacao = new Operacao(contaUm, TipoOperacao.DEBITO, valor);
                            try {
                                pilha.push(operacao);
                                count++;
                            } catch (Exception ex) {
                                System.out.println(ex.getCause());
                            }

                        }
                    } else if (numeroConta == 2) {
                        if (contaDois.debitar(valor)) {
                            Operacao operacao = new Operacao(contaDois, TipoOperacao.DEBITO, valor);
                            try {
                                pilha.push(operacao);
                                count++;
                            } catch (Exception ex) {
                                System.out.println(ex.getCause());
                            }
                        }
                    }

                    break;

                case "2":

                    System.out.println("Digite o número da conta que deseja: ");
                    numeroConta = sc.nextInt();
                    System.out.println("Digite o valor desejado: ");
                    valor = sc.nextDouble();


                    if (numeroConta == 1) {

                        contaUm.creditar(valor);
                        Operacao operacao = new Operacao(contaUm, TipoOperacao.DEBITO, valor);
                        try {
                            pilha.push(operacao);
                            count++;
                        } catch (Exception ex) {
                            System.out.println(ex.getCause());
                        }


                    } else if (numeroConta == 2) {

                        contaDois.creditar(valor);
                        Operacao operacao = new Operacao(contaDois, TipoOperacao.DEBITO, valor);
                        try {
                            pilha.push(operacao);
                            count++;
                        } catch (Exception ex) {
                            System.out.println(ex.getCause());
                        }

                    }


                    break;

                case "3":

                    System.out.println("Quantas operações deseja desfazer?");

                    int qntOperacoes = in.nextInt();

                    if(qntOperacoes > count)
                    {
                        System.out.println("Essa quantidade é inválida");
                    }else {

                        for (int i = 0; i < qntOperacoes; i++) {

                            Operacao operacao = pilha.pop();

                            if (operacao.getObjConta().getNumero() == 1) {

                                if (operacao.getTipoOperacao() == TipoOperacao.CREDITO) {

                                    contaUm.debitar(operacao.getValor());

                                } else {
                                    contaUm.creditar(operacao.getValor());
                                }
                                count--;

                            } else {
                                if (operacao.getTipoOperacao() == TipoOperacao.CREDITO) {
                                    contaDois.debitar(operacao.getValor());
                                } else {
                                    contaDois.creditar(operacao.getValor());
                                }
                                count--;
                            }

                        }
                    }

                    break;

                case "4":


                    System.out.println("Qual operação deseja fazer? Crédito ou Débito?");

                    String operacao = in.next();

                    System.out.println("Qual o número da conta que deseja?");

                    numeroConta = in.nextInt();

                    System.out.println("Qual o valor que deseja?");

                    valor = in.nextDouble();

                    try{

                        Operacao operacao1 = new Operacao(numeroConta==1?contaUm:contaDois, TipoOperacao.valueOf(operacao.toUpperCase()), valor);

                        fila.enfileirar(operacao1);

                    }catch (Exception e){
                        System.out.println("Essa operação não é permitida");
                    }


                    break;

                case "5":

                    if(fila.estaVazia()){
                        System.out.println("Não tem operações agendadas");
                    }else{

                        for(int i = 0; i< fila.tamanho(); i++){


                            Operacao op = fila.desenfileirar();

                            if(op.getObjConta().getNumero() == 1){

                                if(op.getTipoOperacao() == TipoOperacao.DEBITO){
                                    contaUm.debitar(op.getValor());
                                }else{
                                    contaUm.creditar(op.getValor());
                                }

                            }else{

                                if(op.getTipoOperacao() == TipoOperacao.DEBITO){
                                    contaDois.debitar(op.getValor());
                                }else{
                                    contaDois.creditar(op.getValor());
                                }

                            }


                        }

                    }
                    break;

                default:
                    System.out.println("Digite uma opção válida");
                    break;
            }

        }

        System.out.println("\n Programa finalizado :)");

    }
}