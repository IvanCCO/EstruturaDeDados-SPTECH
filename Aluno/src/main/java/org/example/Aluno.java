package org.example;

public abstract class Aluno {

    private Integer ra;
    private String nome;

    public Integer getRa() {
        return ra;
    }
    public String getNome() {
        return nome;
    }

    public Aluno(Integer ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }


    public abstract Double calculaMedia();

    @Override
    public String toString() {
        return "Aluno{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                '}';
    }

}
