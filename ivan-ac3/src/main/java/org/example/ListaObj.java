package org.example;

public class ListaObj <T> {

    private T[] vetor;

    private int nroElem;

    public ListaObj(int tamanho) {



    }

    // 04) Método adiciona:
    // Recebe o elemento a ser adicionado na lista
    // Se a lista estiver cheia usar IllegalStateException();
    public void adiciona(T elemento) {

    }

    // 05) Método busca:
    // Recebe o elemento a ser procurado na lista
    // Retorna o índice do elemento, se for encontrado
    // Retorna -1 se não encontrou
    public int busca(T elementoBuscado) {
        return -1;
    }

    // 06) Método removePeloIndice:
    // Recebe o índice do elemento a ser removido
    // Se o índice for inválido, retorna false
    // Se removeu, retorna true
    public boolean removePeloIndice(int indice) {
        return true;
    }

    // 07) Método removeElemento
    // Recebe um elemento a ser removido
    // Utiliza os métodos busca e removePeloIndice
    // Retorna false, se não encontrou o elemento
    // Retorna true, se encontrou e removeu o elemento
    public boolean removeElemento(T elementoARemover) {
        return true;
    }

    // 08) Método getTamanho
    // Retorna o tamanho da lista
    public int getTamanho() {
        return -1;
    }

    // 09) Método getElemento
    // Recebe um índice e retorna o elemento desse índice
    // Se o índice for inválido, retorna null
    public T getElemento(int indice) {
        return null;
    }

    // 10) Método limpa
    // Limpa a lista
    public void limpa() {

    }

    // 11) Método exibe:
    // Exibe os elementos da lista
    public void exibe() {

    }

    // Get do vetor
    // Não retirar, é usado nos testes
    public T[] getVetor() {
        return null;
    }
}
