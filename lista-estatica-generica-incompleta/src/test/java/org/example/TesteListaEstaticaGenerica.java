package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class TesteListaEstaticaGenerica {
    @Test
    public void criarListaAlteraTamanhoVetor() {
        ListaObj lista = new ListaObj(3);
        assertEquals(3, lista.getVetor().length);
    }

    @Test
    public void criarListaInicializaTamanho() {
        ListaObj lista = new ListaObj(3);
        assertEquals(0, lista.getNroElem());
    }

    @Test
    public void adicionaAlteraVetor() {
        ListaObj lista = new ListaObj(3);

        lista.adiciona(1);
        lista.adiciona("A");
        lista.adiciona(false);

        assertEquals("A", lista.getVetor()[1]);
    }

    @Test
    public void adicionaAlteraTamanho() {
        ListaObj lista = new ListaObj(3);

        assertEquals(0, lista.getNroElem());

        lista.adiciona(1);

        assertEquals(1, lista.getNroElem());

        lista.adiciona("A");

        assertEquals(2, lista.getNroElem());
    }

    @Test
    public void adicionaValidaListaCheia() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona("A");
        lista.adiciona(2);
        lista.adiciona(false);
        assertThrows(IllegalStateException.class, () -> lista.adiciona(4));
    }

    @Test
    public void buscaPorElementoQuandoNaoEntrado() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona("A");
        lista.adiciona(2);
        lista.adiciona(false);
        assertEquals(-1, lista.buscaPorElemento(35));

    }

    @Test
    public void buscaPorElementoQuandoElementoValido() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.adiciona(false);
        assertEquals(1, lista.buscaPorElemento("A"));
    }

    @Test
    public void removePorIndiceQuandoIndiceInvalido() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        assertFalse(lista.removePorIndice(3));
        assertFalse(lista.removePorIndice(-3));
    }

    @Test
    public void removePorIndiceQuandoListaCheia() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.adiciona(false);
        assertTrue(lista.removePorIndice(1));
    }

    @Test
    public void removePorIndiceQuandoIndiceValido() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        assertTrue(lista.removePorIndice(1));
    }

    @Test
    public void removePorIndiceAlteraTamanho() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.removePorIndice(1);

        assertEquals(1, lista.getNroElem());
    }

    @Test
    public void removePorIndiceAlteraVetor() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.removePorIndice(0);

        assertEquals("A", lista.getVetor()[0]);
    }

    @Test
    public void removerPorElementoQuandoElementoInvalido() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        assertFalse(lista.removerPorElemento(3));
        assertFalse(lista.removerPorElemento("C"));
    }

    @Test
    public void removerPorElementoQuandoElementoListaCheia() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.adiciona(false);
        assertTrue(lista.removerPorElemento("A"));
    }

    @Test
    public void removerPorElementoQuandoElementoValido() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        assertTrue(lista.removerPorElemento("A"));
    }

    @Test
    public void removerPorElementoAlteraTamanho() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.removerPorElemento("A");

        assertEquals(1, lista.getNroElem());
    }

    @Test
    public void removerPorElementoAlteraVetor() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.removerPorElemento(1);

        assertEquals("A", lista.getVetor()[0]);
    }

    @Test
    public void getTamanho() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona("A");
        lista.adiciona("B");

        assertEquals(2, lista.getNroElem());
    }

    @Test
    public void getTamanhoQuandoListaCheia() {
        ListaObj lista = new ListaObj(3);
        lista.adiciona(1);
        lista.adiciona("A");
        lista.adiciona(false);

        assertEquals(3, lista.getNroElem());
    }

    @Test
    public void getTamanhoQuandoListaVazia() {
        ListaObj lista = new ListaObj(3);
        assertEquals(0, lista.getNroElem());
    }

}