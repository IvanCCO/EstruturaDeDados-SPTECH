package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Escola {

    private String nome;
    private ArrayList<Aluno>alunoList;

    public Escola(String nome) {
        this.nome = nome;
        this.alunoList = new ArrayList();
    }

    // Métodos

    public void adicionarAluno(Aluno aluno){

        alunoList.add(aluno);

    }

    public void exibeTodos(){

        for(Aluno aluno: alunoList){
            System.out.println(aluno.getNome());
        }

    }

    public void exibeAlunoGraduacao(){
        for(Aluno aluno: alunoList){
            if(aluno instanceof AlunoGraduacao){
                System.out.println(aluno.getNome());
            }
        }
    }

    public void exibeAprovados(){

        for(Aluno aluno: alunoList){

            if(aluno.calculaMedia() >= 6.0){
                System.out.println(aluno.getNome());
            }

        }

    }

    public void buscaAluno(Integer ra){

        for(Aluno aluno: alunoList){

            if(Objects.equals(aluno.getRa(), ra)){
                System.out.println(aluno.getNome());
            }

        }

    }
}
