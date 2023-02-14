package org.example;

public class Servico implements Vendavel{

    private String descricao;
    private int codigo;
    private int qntHoras;
    private Double valorHora;

    public Servico(String descricao, int codigo, int qntHoras, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qntHoras = qntHoras;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorVenda() {
        return qntHoras * valorHora;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", qntHoras=" + qntHoras +
                ", valorHora=" + valorHora +
                "Preço= " + getValorVenda();
    }
}
