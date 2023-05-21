package org.example;

public class Repositorio<T extends Animacao> {

    private ListaObj<Animacao> listaAnimacao;

    private PilhaObj<Operacao> pilhaOperacao;

    private FilaObj<Integer> filaInteger;

    private int count=0;

    public Repositorio() {
        this.listaAnimacao = new ListaObj<>(20);
        this.pilhaOperacao = new PilhaObj<>(10);
        this.filaInteger = new FilaObj<>(10);
    }


    public void adicionalistaAnimacao (Animacao animacao) {

        listaAnimacao.adiciona(animacao);

    }

    public void deletarPeloId(int id) {
        boolean encontrado = false;
        for (int i = 0; i < listaAnimacao.getTamanho(); i++) {
            Animacao x = listaAnimacao.getElemento(i);
            if (x.getId() == id) {
                listaAnimacao.removePeloIndice(i);
                encontrado = true;
                System.out.println("Animacao removida");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("id inválido");
        }
    }

    public void aumentarValorPeloId(int id, double valorDeAumento) {
        boolean encontrado = false;
        for (int i = 0; i < listaAnimacao.getTamanho(); i++) {
            Animacao x = listaAnimacao.getElemento(i);
            if (x.getId() == (id)) {
                double valorAntigo = x.getValor();
                x.setValor(valorAntigo + valorDeAumento);
                Operacao operacao = new Operacao(id, (int) -valorDeAumento);
                pilhaOperacao.push(operacao);
                encontrado = true;
                System.out.println("Valor aumentado");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("id inválido");
        }
    }

    public void diminuirValorPeloId(int id, double valorDeDiminuicao) {
        boolean encontrado = false;
        for (int i = 0; i < listaAnimacao.getTamanho(); i++) {
            Animacao x = listaAnimacao.getElemento(i);
            if (x.getId() == id) {
                double valorAntigo = x.getValor();
                x.setValor(valorAntigo - valorDeDiminuicao);
                encontrado = true;
                System.out.println("Valor Diminuido");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("id inválido");
        }
    }

    public void desfazer(int qtdOperacoesADesfazer) {
        if (qtdOperacoesADesfazer <= 0 || qtdOperacoesADesfazer-1 > pilhaOperacao.getTopo()) {
            System.out.println("Quantidade de operações inválida");
            return;
        }
        if (pilhaOperacao.isEmpty()) {
            System.out.println("Nada a desfazer");
            return;
        }
        for (int i = 0; i < qtdOperacoesADesfazer; i++) {
            Operacao operacao = pilhaOperacao.pop();
            diminuirValorPeloId(operacao.getId(), operacao.getValorDeAumento());
        }
    }

    public void agendarDeletarPeloId(int id) {
        filaInteger.enfileirar(id);
    }

    public void exibir() {

        int n = listaAnimacao.getTamanho();
        int m = 5;
        String[][] matriz = new String[n][m];

        for(int i = 0; i < matriz.length; i++) {
            double media = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0) {
                    matriz[i][j] = listaAnimacao.getElemento(i).getTitulo();
                } else if (j == 1) {
                    matriz[i][j] = String.valueOf(listaAnimacao.getElemento(i).getAnoLancamento());
                    media += listaAnimacao.getElemento(i).getAnoLancamento();
                } else if (j == 2) {
                    matriz[i][j] = String.valueOf(listaAnimacao.getElemento(i).getValor());
                    media += listaAnimacao.getElemento(i).getValor();
                } else if (j == 3) {
                    matriz[i][j] = String.valueOf(listaAnimacao.getElemento(i).getDuracaoEpisodio());
                    media += listaAnimacao.getElemento(i).getDuracaoEpisodio();
                }else if(j == 4){

                    matriz[i][j] = String.format("%.2f", media/3);

                }
            }
        }

        System.out.println("Nome\tAnoLancamento\tValor\tDuracao\tMédia");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(String.format("%-10s", matriz[i][j]));
            }
            double soma = 0;
            for (int j = 1; j < matriz[i].length; j++) {
                soma += Double.parseDouble(matriz[i][j]);
            }
            double mediaLinha = soma / (matriz[i].length - 1);
            System.out.printf("%-10.2f", mediaLinha);
            System.out.println();
        }


    }





}
