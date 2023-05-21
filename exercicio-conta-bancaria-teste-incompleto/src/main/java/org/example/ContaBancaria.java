package org.example;
public class ContaBancaria {

    // Atributos
    private Integer numero;
    private Double saldo;

    // Construtor

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }


    // Métodos

    /* Método debitar - recebe o valor a ser debitado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Se o saldo for insuficiente para o débito, retorna false
       Senão, atualiza o saldo e retorna true
     */

    public Boolean debitar(Double valor){

        if(valor == null){
            throw new IllegalArgumentException();
        }

        if(valor <= 0 ){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }

        if(saldo - valor < 0){
            System.out.println("Saldo insuficiente");
            return false;
        }

        System.out.println("Saldo atual : " + saldo );

        this.saldo -= valor;

        System.out.println("Saldo após operação " + saldo);

        return true;

    }

    /* Método creditar - recebe o valor a ser depositado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Senão, atualiza o saldo
     */
    public void creditar(Double valor){

        // Atualiza o valor do saldo e exibe o saldo
        if(valor == null){
            throw new IllegalArgumentException();
        }

        if(valor <= 0){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        System.out.println(String.format("O saldo era é de %.2f", saldo));

        saldo += valor;

        System.out.println(String.format("O saldo atual é de %.2f", saldo));

    }


    /* Método toString() - retorna uma String formatada com o número e o saldo da conta. */
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }



    // Getters
    public Integer getNumero() {

        return this.numero;

    }

    public Double getSaldo() {
        return this.saldo;
    }

}
