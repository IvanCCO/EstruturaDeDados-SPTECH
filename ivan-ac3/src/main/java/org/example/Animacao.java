package org.example;

public class Animacao {

    private int id;

    private double valor;

    private int anoLancamento;

    private String titulo;

    private Double duracaoEpisodio;

    private String estudioProducao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Animacao(int id, double valor, int anoLancamento, String titulo, Double duracaoEpisodio, String estudioProducao) {
        this.id = id;
        this.valor = valor;
        this.anoLancamento = anoLancamento;
        this.titulo = titulo;
        this.duracaoEpisodio = duracaoEpisodio;
        this.estudioProducao = estudioProducao;
        System.out.println("Animação criada");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }



    public Double getDuracaoEpisodio() {
        return duracaoEpisodio;
    }

    public void setDuracaoEpisodio(Double duracaoEpisodio) {
        this.duracaoEpisodio = duracaoEpisodio;
    }

    public String getEstudioProducao() {
        return estudioProducao;
    }

    public void setEstudioProducao(String estudioProducao) {
        this.estudioProducao = estudioProducao;
    }
}
