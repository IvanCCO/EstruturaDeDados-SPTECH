package org.example;

public class ListaObj <T>{

    private T[] vetor;

    private int nroElem;


    public int getNroElem() {
        return nroElem;
    }

    public T[] getVetor() {
        return vetor;
    }

    public ListaObj(int tamanhoVetor) {
        this.vetor =  (T[]) new Object[tamanhoVetor];
        this.nroElem = 0;
    }

    public void adiciona(Object numero){
        if(vetor.length == nroElem){
            throw new IllegalStateException();
        }else{
            vetor[nroElem] = (T) numero;
            nroElem++;
        }
    }

    public void exibirVetor(){

        for(int i=0; i<nroElem; i++){
            System.out.println(vetor[i]);
        }

    }

    public int buscaPorElemento(T elemento){

        for(int i = 0; i<vetor.length; i++){
            if(vetor[i] == elemento){
                return i;
            }
        }
        return -1;
    }

    public boolean removePorIndice(int index){
        if(index >= 0 && index < nroElem){
            for(int i =0; i< nroElem-1; i++){
                vetor[i] = vetor[i+1];
            }
            nroElem--;
            return true;
        }
        return false;
    }

    public boolean removerPorElemento(T elemento){

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

