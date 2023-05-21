package org.example;

public class FilaObj<T> {
    private T[] fila;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaObj(int capacidade) {
        fila = (T[]) new Object[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T elemento) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }

        fim++;
        if (fim == fila.length) {
            fim = 0;
        }

        fila[fim] = elemento;
        tamanho++;
    }

    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }

        T elemento = fila[inicio];
        fila[inicio] = null;
        inicio++;
        if (inicio == fila.length) {
            inicio = 0;
        }

        tamanho--;
        return elemento;
    }

    public T peek(){
        return fila[inicio];
    }


    public int tamanho() {
        return tamanho;
    }
}

