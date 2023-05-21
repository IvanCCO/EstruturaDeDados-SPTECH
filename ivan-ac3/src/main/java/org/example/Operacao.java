package org.example;

public class Operacao {

    private int id;
    private int valorDeAumento;

    public Operacao(int id, int valorDeAumento) {
        this.id = id;
        this.valorDeAumento = valorDeAumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorDeAumento() {
        return valorDeAumento;
    }

    public void setValorDeAumento(int valorDeAumento) {
        this.valorDeAumento = valorDeAumento;
    }
}
