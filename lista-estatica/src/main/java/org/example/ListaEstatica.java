package org.example;

import java.util.Arrays;

public class ListaEstatica {


    private int[] vetor;
    private int nroElem = 0;


    public ListaEstatica(int[] vetor) {
        this.vetor = new int[5];
    }

    public void adiciona(int numero){
        if(vetor.length == nroElem){
            System.out.println("Não é possível adicionar na lista");
        }else{
            vetor[nroElem] = numero;
            nroElem++;
        }
    }

    public void exibirVetor(){

        for(int i=0; i<nroElem; i++){
            System.out.println(vetor[i]);
        }

    }

    public int buscaPorElemento(int elemento){

        for(int i = 0; i<vetor.length; i++){
            if(vetor[i] == elemento){
                return i;
            }
        }
        return -1;
    }

    public boolean removePorIndice(int index){
        if(index < nroElem){
            for(int i =0; i< nroElem-1; i++){
                vetor[i] = vetor[i+1];
            }
            nroElem--;
            return true;
            }
        return false;
    }

    public boolean removerPorElemento(int elemento){

        int index = buscaPorElemento(elemento);
        if(index < 0) {
            return false;
        }
        for(; index< nroElem-1; index++){
            vetor[index] = vetor[index+1];
        }
        nroElem--;
        return true;
        }


    }

