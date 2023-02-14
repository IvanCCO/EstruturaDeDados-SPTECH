package org.example;

public class TesteAluno {
    public static void main(String[] args) {

         AlunoFundamental alunoFundamental = new AlunoFundamental(22222, "Jeremy", 8.00, 8.21, 5.32, 9.21);
         AlunoGraduacao alunoGraduacao = new AlunoGraduacao(23232, "Xux", 10.00, 8.54);
         AlunoPos alunoPos = new AlunoPos(2131, "Martizes", 3.42, 4.5, 6.4);


        Escola escola = new Escola("SPTECH");

        escola.adicionarAluno(alunoFundamental);
        escola.adicionarAluno(alunoPos);
        escola.adicionarAluno(alunoGraduacao);

        escola.exibeTodos();
        escola.buscaAluno(22222);
        escola.exibeAprovados();
        escola.exibeAlunoGraduacao();



    }
}