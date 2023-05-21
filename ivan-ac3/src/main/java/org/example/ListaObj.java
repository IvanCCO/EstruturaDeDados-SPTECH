package org.example;

import java.util.NoSuchElementException;

public class ListaObj<T> {

    private T[] vetor;

    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    public void adiciona(T elemento) {
        if (nroElem == vetor.length) {
            throw new IllegalStateException("A lista está cheia.");
        }
        vetor[nroElem++] = elemento;
    }

    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }


    public void removePeloIndice(int indice) {
        if (indice < 0 || indice >= nroElem) {
            throw new NoSuchElementException();
        }
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        nroElem--;
    }

    public void removeElemento(T elementoARemover) {
        int indice = busca(elementoARemover);
        if (indice == -1) {
            throw new NoSuchElementException();
        }
       removePeloIndice(indice);
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        return vetor[indice];
    }

    public void limpa() {
        nroElem = 0;
    }


    public void exibe() {
        for (int i = 0; i < nroElem; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public T[] getVetor() {
        return vetor;
    }

    public void adicionaNoIndice(T valor, int indice) {
        if (indice < 0 || indice > nroElem) {
            System.out.println("Índice inválido");
            return;
        }

        if (nroElem == vetor.length) {
            throw new IllegalStateException("A lista está cheia");
        }


        for (int i = nroElem - 1; i >= indice; i--) {
            vetor[i + 1] = vetor[i];
        }

        vetor[indice] = valor;
        nroElem++;
    }

}
