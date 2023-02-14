package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Vendavel> cart;

    public Carrinho() {
        this.cart = new ArrayList<>();
    }


    public void adicionaVendavel(Vendavel venda){

        cart.add(venda);

    }

    public Double calculaTotalVenda(){

        double soma = 0;

        for(Vendavel vendas: cart){

            soma += vendas.getValorVenda();

        }

        return soma;
    }

    public void exibeItensCarrinho(){

        for(Vendavel vendas: cart){

            System.out.println(vendas.toString());

        }

    }



}
