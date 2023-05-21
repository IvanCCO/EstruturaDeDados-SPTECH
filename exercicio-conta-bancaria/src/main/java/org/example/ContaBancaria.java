package org.example;

public class ContaBancaria {

    private Integer numero;

    private Double saldo;


    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Se não tiver saldo suficiente retorna false se tiver debita e retorna true
    public Boolean debitar(Double valor){

        if(saldo - valor < 0){
            System.out.println("Saldo insuficiente");
            return false;
        }

        System.out.println("Saldo atual : " + saldo );

        this.saldo -= valor;

        System.out.println("Saldo após operação " + saldo);

        return true;

    }

    public void creditar(Double valor){

        // Atualiza o valor do saldo e exibe o saldo

        if(valor < 0){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        System.out.println(String.format("O saldo era é de %.2f", saldo));

        saldo += valor;

        System.out.println(String.format("O saldo atual é de %.2f", saldo));

    }




    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
